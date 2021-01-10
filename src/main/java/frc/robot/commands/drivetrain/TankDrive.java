/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import frc.robot.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * ArcadeDrive command using methods from the Drivetrain subsystem
 */
public class TankDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain drivetrain;
  private final DoubleSupplier left, right;

  /**
   * TankDrive command, allows the robot to be controlled using tank controls
   * Drivetrain subsystem: @param drivetrain
   * Speed of the drivetrain motors on the left side: @param left
   * Speed of the drivetrain motors on the right side: @param right
   */
  public TankDrive(Drivetrain drivetrain, DoubleSupplier left, DoubleSupplier right) {
    this.drivetrain = drivetrain;
    this.left = left;
    this.right = right;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("DriveTrainLeft", left.getAsDouble());
    SmartDashboard.putNumber("DriveTrainRight", right.getAsDouble());
    drivetrain.tankDrive(left.getAsDouble(), right.getAsDouble());
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
