/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.auto.ShootInTargetZone;
import frc.robot.commands.climber.LowerClimber;
import frc.robot.commands.climber.RaiseClimber;
import frc.robot.commands.collector.Collect;
import frc.robot.commands.collector.CollectorArmIn;
import frc.robot.commands.collector.CollectorArmOut;
import frc.robot.commands.collector.Eject;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.commands.drivetrain.TankDrive;
import frc.robot.commands.feeder.FeederIn;
import frc.robot.commands.hopper.HopperIn;
import frc.robot.commands.hopper.HopperOut;
import frc.robot.commands.shooter.Shoot;
import frc.robot.commands.shooter.ShooterIn;
import frc.robot.commands.shooter.ShooterOut;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;
import frc.robot.utils.Gamepad;
import frc.robot.utils.JoystickAnalogButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain drivetrain = new Drivetrain();
  private final Shooter shooter = new Shooter();
  private final Feeder feeder = new Feeder();
  private final Collector collector = new Collector();
  private final Hopper hopper = new Hopper();
  private final Climber climber = new Climber();

  Gamepad gamepad = new Gamepad(Constants.GAMEPAD);
  JoystickAnalogButton leftTrigger = new JoystickAnalogButton(gamepad, 2);
  JoystickAnalogButton rightTrigger = new JoystickAnalogButton(gamepad, 3);

  private final Command autoCommand = new ShootInTargetZone(drivetrain, shooter, hopper, collector, feeder);
  // private final Command autoCommand = null; // TODO: figure out why this works

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Setting the drive controls to arcade
    drivetrain.setDefaultCommand(
      new ArcadeDrive(
        drivetrain, 
        () -> -getGamepadLeftY(),
        () -> getGamepadRightX()
      )
    );

    // Setting the drive controls to tank
    // drivetrain.setDefaultCommand(
    //   new TankDrive(
    //     drivetrain, 
    //     () -> getGamepadLeftY(),
    //     () -> getGamepadRightY()
    //   )
    // );
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Eric's controls because stuff was broken. 
    // Run intake - LB 
    gamepad.getLeftShoulder().whileHeld(new Collect(collector, () -> 0.85));

    // Run outtake - RB
    gamepad.getRightShoulder().whileHeld(new Eject(collector, () -> 0.75));

    // Run shooter motor - LT
    leftTrigger.whileHeld(new ShooterOut(shooter, () -> 0.75));

    // Shoot balls - RT
    rightTrigger.whileHeld(new FeederIn(feeder, () -> 0.5));
    rightTrigger.whileHeld(new HopperIn(hopper, () -> 0.5, () -> 0.75));
    rightTrigger.whileHeld(new Collect(collector, () -> 0.85));

    // Deploy intake out - A
    gamepad.getButtonA().whenPressed(new CollectorArmOut(collector));

    // Deploy intake in - B
    gamepad.getButtonB().whenPressed(new CollectorArmIn(collector));

    /* TEST THIS COMMAND */
    // Spin shooter wheels for 1.5s, then shoot balls
    gamepad.getButtonX().whileHeld(
      new Shoot(
        shooter, 
        // Shooter power
        () -> 0.75, 
        hopper, 
        // Hopper power left
        () -> 0.5, 
        // Hopper power right
        () -> 0.7, 
        collector, 
        // Collector power
        () -> 0.85, 
        feeder,
        // Feeder power
        () -> 0.5
      )
    );

    gamepad.getButtonY().whileHeld(new HopperOut(hopper, () -> 0.4, () -> 0.4));

    // // Prepare climber to hang - Y
    // gamepad.getButtonY().whileHeld(new RaiseClimber(climber, () -> 1));

    // // Pull robot up - X
    // gamepad.getButtonX().whileHeld(new LowerClimber(climber, () -> 1));
  }

  /**
   * Reads the Y-axis value of the left joystick on the gamepad
   * @return Y-axis value
   */
  private double getGamepadLeftY() {
    double y = gamepad.getLeftY();
    SmartDashboard.putNumber("GamepadLeftY", y);
    if(Math.abs(y) < 0.1) {
      y = 0;
    }
    return y;
  }

   /**
   * Reads the Y-axis value of the right joystick on the gamepad
   * @return Y-axis value
   */
  private double getGamepadRightY() {
    double y = gamepad.getRightY();
    SmartDashboard.putNumber("GamepadRightY", y);
    if(Math.abs(y) < 0.1) {
      y = 0;
    }
    return y;
  }

   /**
   * Reads the X-axis value of the right joystick on the gamepad
   * @return X-axis value
   */
  private double getGamepadRightX() {
    double x = gamepad.getRightX();
    SmartDashboard.putNumber("GamepadRigthX", x);
    if(Math.abs(x) < 0.1) {
      x = 0;
    }
    return x;
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // Run the specified autonomous command
    return autoCommand;
  }
}
