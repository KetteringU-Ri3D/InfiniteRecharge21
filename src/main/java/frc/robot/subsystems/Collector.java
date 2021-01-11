/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Collector extends SubsystemBase {
  VictorSP collectorMotor = new VictorSP(Constants.COLLECTOR);
  DoubleSolenoid armSolenoid = new DoubleSolenoid(Constants.ARM_OUT, Constants.ARM_IN);

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
    collectorMotor.set(power);
  }

  /**
   * Spin the collector motor outwards to eject power cells
   * Power applied to the motor: @param power
   */
  public void eject(double power) {
    collectorMotor.set(-power);
  }

  /**
   * Stops the collector motor
   */
  public void stopCollector(){
    collectorMotor.stopMotor();
  }

  /**
   * Opens the collector
   */
  public void armOut() {
    armSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  /**
   * Closes the collector
   */
  public void armIn() {
    armSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  /**
   * Stops the collector arm
   */
  public void armStop() {
    armSolenoid.set(DoubleSolenoid.Value.kOff);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
