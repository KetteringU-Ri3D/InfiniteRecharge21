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
import frc.robot.commands.hopper.HopperIn;
import frc.robot.commands.hopper.HopperOut;
import frc.robot.commands.shooter.FeederIn;
import frc.robot.commands.shooter.FeederOut;
import frc.robot.commands.shooter.ShooterIn;
import frc.robot.commands.shooter.ShooterOut;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivetrain;
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
  private final Collector collector = new Collector();
  private final Hopper hopper = new Hopper();
  private final Climber climber = new Climber();

  Gamepad gamepad = new Gamepad(Constants.GAMEPAD);
  JoystickAnalogButton leftTrigger = new JoystickAnalogButton(gamepad, 2);
  JoystickAnalogButton rightTrigger = new JoystickAnalogButton(gamepad, 3);

  private final Command autoCommand = new ShootInTargetZone(drivetrain);
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
    // // Set up collector so intake is independent of the hopper.
    // // Run intake in - LT
    // leftTrigger.whileHeld(new Collect(collector, () -> 0.75));

    // // Set up all eject commands so they all work from one button.
    // // Get rid of all balls - LB
    // gamepad.getLeftShoulder().whileHeld(new Eject(collector, () -> 0.25));
    // gamepad.getLeftShoulder().whileHeld(new ShooterIn(shooter, () -> 0.5));
    // gamepad.getLeftShoulder().whileHeld(new FeederOut(shooter, () -> 0.5));
    // gamepad.getLeftShoulder().whileHeld(new HopperOut(hopper, () -> 0.5));

    // // Set up shooter to work as a toggle.
    // // Run Shooter - RB
    // gamepad.getRightShoulder().toggleWhenPressed(new ShooterOut(shooter, () -> 0.75));

    // // Set up the hopper and feeder so they work off the same button.
    // // Shoot balls (run indexer/hopper) - RT
    // rightTrigger.whileHeld(new FeederIn(shooter, () -> 0.5));
    // rightTrigger.whileHeld(new HopperIn(hopper, () -> 0.5));

    // // Controls for the climber.
    // /*
    // gamepad.getButtonY().whileHeld(new RaiseClimber(climber, () -> 1));
    // gamepad.getButtonX().whileHeld(new LowerClimber(climber, () -> 1));
    // */

    // // Deploy intake controls - A & B
    // gamepad.getButtonA().whenPressed(new CollectorArmOut(collector));
    // gamepad.getButtonB().whenPressed(new CollectorArmIn(collector));


    // Eric's controls because stuff was broken. 
    // prep shooter - Left Bumper
    //gamepad.getLeftShoulder().toggleWhenPressed(new ShooterOut(shooter, () -> 0.75));
    //gamepad.getLeftShoulder().whileHeld(new ShooterOut(shooter, () -> 0.75));

    // Run shooter motor - LT
    leftTrigger.whileHeld(new ShooterOut(shooter, () -> 0.75));

    // shoot balls - RT
    //gamepad.getRightShoulder().whileHeld(new ShooterOut(shooter, () -> 0.75));
    rightTrigger.whileHeld(new FeederIn(shooter, () -> 0.5));
    rightTrigger.whileHeld(new HopperIn(hopper, () -> 0.55, () -> 0.45));

    // intake - X
    gamepad.getButtonX().whileHeld(new Collect(collector, () -> 0.85));
    // outtake - Y
    gamepad.getButtonY().whileHeld(new Eject(collector, () -> 0.75));

    // pneumatic controls - A & B
    gamepad.getButtonA().whenPressed(new CollectorArmOut(collector));
    gamepad.getButtonB().whenPressed(new CollectorArmIn(collector));

    // Run intake - RB
    gamepad.getRightShoulder().whileHeld(new Collect(collector, () -> 0.75));
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
