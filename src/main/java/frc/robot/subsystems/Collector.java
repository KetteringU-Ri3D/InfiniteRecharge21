/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Collector extends SubsystemBase {
  WPI_TalonSRX collectorMotor = new WPI_TalonSRX(Constants.COLLECTOR);

  /**
   * Collector object
   */
  public Collector() {
  }

  /**
   * Spin the collector motor inwards to collect power cells
   * Power applied to the motor: @param power
   */
  public void collect(double power) {
    collectorMotor.set(ControlMode.PercentOutput, power);
  }

  /**
   * Spin the collector motor outwards to eject power cells
   * Power applied to the motor: @param power
   */
  public void eject(double power) {
    collectorMotor.set(ControlMode.PercentOutput, -power);
  }

  /**
   * Stops the collector motor
   */
  public void stopCollector(){
    collectorMotor.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
