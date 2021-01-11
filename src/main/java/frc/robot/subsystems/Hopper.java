/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hopper extends SubsystemBase {
  VictorSP hopperMotorL = new VictorSP(Constants.HOPPER_L);
  VictorSP hopperMotorR = new VictorSP(Constants.HOPPER_R);

  /**
   * Hopper object
   */
  public Hopper() {
  }

  /**
   * Spins the hopper motors inward, moving power cells into the shooter
   * Power applied to the motors: @param power
   */
  public void hopperIn(double power) {
    hopperMotorL.set(-power + 0.05);
    hopperMotorR.set(power - 0.05);
  }

  /**
   * Spins the hopper motors outward, moving power cells towards the collector
   * Power applied to the motors: @param power
   */
  public void hopperOut(double power) {
    hopperMotorL.set(power + 0.05);
    hopperMotorR.set(-power - 0.05);
  }

  /** 
   * Stop the hopper motors
   */
  public void hopperStop() {
    hopperMotorR.stopMotor();
    hopperMotorL.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
