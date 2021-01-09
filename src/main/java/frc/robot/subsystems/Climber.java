/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  WPI_VictorSPX climberMotor = new WPI_VictorSPX(Constants.CLIMBER);
  
  /**
   * Climber object
   */
  public Climber() { 
  }

  /**
   * Raise the climber
   * Power applied to the motor: @param power
   */
  public void raiseClimber(double power) {
    climberMotor.set(ControlMode.PercentOutput, power);
  }

  /**
   * Lower the climber
   * Power applied to the motor: @param power
   */
  public void lowerClimber(double power) {
    climberMotor.set(ControlMode.PercentOutput, -power);
  }

  /**
   * Stop the climber motor
   */
  public void stopClimber() {
    climberMotor.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
