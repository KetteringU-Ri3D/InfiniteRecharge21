// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Feeder extends SubsystemBase {
  VictorSP feederMotor = new VictorSP(Constants.FEEDER);
  
  /** Creates a new Feeder. */
  public Feeder() {}

  /**
   * Spin the feeder motor inward to bring power cells from the hopper
   * into the shooter
   * Power applied to the motor: @param power
   */
  public void feederIn(double power) {
    feederMotor.set(power);
  }

  /**
   * Spin the feeder motor outward if necessary
   * Power applied to the motor: @param power
   */
  public void feederOut(double power) {
    feederMotor.set(power);
  }

  /** 
   * Stop the feeder motor
   */
  public void feederStop() {
    feederMotor.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
