/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

/**
 * ArcadeDrive command using methods from the Drivetrain subsystem
 */
public class ArcadeDrive extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final Drivetrain drivetrain;
  private final DoubleSupplier throttle, rotation;

  /**
   * ArcadeDrive command, allows the robot to be controlled using arcade controls
   * Drivetrain subsystem: @param drivetrain Speed of moving
   * forwards/backwards: @param throttle Speed of rotation: @param rotation
   */
  public ArcadeDrive(Drivetrain drivetrain, DoubleSupplier throttle, DoubleSupplier rotation) {
    this.drivetrain = drivetrain;
    this.throttle = throttle;
    this.rotation = rotation;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("DriveTrainThrottle", throttle.getAsDouble());
    SmartDashboard.putNumber("DriveTrainRotation", rotation.getAsDouble());
    drivetrain.arcadeDrive(throttle.getAsDouble(), rotation.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stopDrive();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
