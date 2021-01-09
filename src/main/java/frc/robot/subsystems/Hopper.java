/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hopper extends SubsystemBase {
  WPI_VictorSPX hopperMotorL = new WPI_VictorSPX(Constants.HOPPER_L);
  WPI_TalonSRX hopperMotorR = new WPI_TalonSRX(Constants.HOPPER_R);

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
    hopperMotorL.set(ControlMode.PercentOutput, -power);
    hopperMotorR.set(ControlMode.PercentOutput, power);
  }

  /**
   * Spins the hopper motors outward, moving power cells towards the collector
   * Power applied to the motors: @param power
   */
  public void hopperOut(double power) {
    hopperMotorL.set(ControlMode.PercentOutput, power);
    hopperMotorR.set(ControlMode.PercentOutput, -power);
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