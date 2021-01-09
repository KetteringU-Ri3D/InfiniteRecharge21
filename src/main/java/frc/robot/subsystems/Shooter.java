/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  WPI_TalonFX shooterMotorR = new WPI_TalonFX(Constants.SHOOTER_R);
  WPI_TalonFX shooterMotorL = new WPI_TalonFX(Constants.SHOOTER_L);
  WPI_VictorSPX feederMotor = new WPI_VictorSPX(Constants.SHOOTER_F);

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
   * Stop the shooter motors
   */
  public void shooterStop() {
    shooterMotorL.stopMotor();
    shooterMotorR.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
