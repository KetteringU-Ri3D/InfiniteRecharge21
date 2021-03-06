/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.hopper;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class HopperIn extends CommandBase {
  private final Hopper hopper;
  private final DoubleSupplier powerLeft, powerRight;
  // private final DoubleSupplier power;

  /**
   * HopperIn command, prepares the robot to shoot power cells
   * Hopper subsystem: @param hopper
   * Power applied to the motors: @param power
   */
  public HopperIn(Hopper hopper, DoubleSupplier powerLeft, DoubleSupplier powerRight) {
    this.hopper = hopper;
    this.powerLeft = powerLeft;
    this.powerRight = powerRight;
    addRequirements(hopper);
  }

  // public HopperIn(Hopper hopper, DoubleSupplier power) {
  //   this.hopper = hopper;
  //   this.power = power;
  //   addRequirements(hopper);
  // }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("HopperInPower", powerLeft.getAsDouble());
    hopper.hopperIn(powerLeft.getAsDouble(), powerRight.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    hopper.hopperStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
