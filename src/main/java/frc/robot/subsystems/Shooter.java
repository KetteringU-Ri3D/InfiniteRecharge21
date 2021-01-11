/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  WPI_TalonFX shooterMotorR = new WPI_TalonFX(Constants.SHOOTER_R);
  WPI_TalonFX shooterMotorL = new WPI_TalonFX(Constants.SHOOTER_L);
  VictorSP feederMotor = new VictorSP(Constants.FEEDER);

  /**
   * Shooter object
   */
  public Shooter() {
  }

  /**
   * Spin the shooter motors inwards
   * Power applied to the motors: @param power
   */
  public void shooterIn(double power) {
    shooterMotorL.set(ControlMode.PercentOutput, -power);
    shooterMotorR.set(ControlMode.PercentOutput, power);
  }

  /**
   * Spin the shooter motors outwards, used to shoot power cells
   * Power applied to the motors: @param power
   */
  public void shooterOut(double power) {
    shooterMotorL.set(ControlMode.PercentOutput, power);
    shooterMotorR.set(ControlMode.PercentOutput, -power);
  }

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
   * Stop the shooter motors
   */
  public void shooterStop() {
    shooterMotorL.stopMotor();
    shooterMotorR.stopMotor();
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
