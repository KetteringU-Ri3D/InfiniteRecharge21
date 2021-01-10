/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  WPI_TalonSRX driveMotorFL = new WPI_TalonSRX(Constants.DRIVE_FL);
  WPI_VictorSPX driveMotorRL = new WPI_VictorSPX(Constants.DRIVE_RL);
  WPI_TalonSRX driveMotorFR = new WPI_TalonSRX(Constants.DRIVE_FR);
  WPI_VictorSPX driveMotorRR = new WPI_VictorSPX(Constants.DRIVE_RR);

  SpeedControllerGroup driveLeft = new SpeedControllerGroup(driveMotorFL, driveMotorRL);
  SpeedControllerGroup driveRight = new SpeedControllerGroup(driveMotorFR, driveMotorRR);

  DifferentialDrive drive = new DifferentialDrive(driveLeft, driveRight);

  /**
   * Drivetrain object
   */
  public Drivetrain() {
    // Set drive motors to Brake mode
    driveMotorFL.setNeutralMode(NeutralMode.Brake);
    driveMotorFR.setNeutralMode(NeutralMode.Brake);
    driveMotorRL.setNeutralMode(NeutralMode.Brake);
    driveMotorRR.setNeutralMode(NeutralMode.Brake);
  }

  /**
   * Arcade drive control
   * Speed of moving forwards/backwards: @param throttle
   * Speed of rotation: @param rotation
   */
  public void arcadeDrive(double throttle, double rotation) {
    drive.arcadeDrive(throttle, rotation);
  }

  /**
   * Tank drive control
   * Speed of the drivetrain motors on the left side: @param left
   * Speed of the drivetrain motors on the right side: @param right
   */
  public void tankDrive(double left, double right) {
    drive.tankDrive(left, right);
  }

  /**
   * Stops the drivetrain motors
   */
  public void stopDrive(){
    drive.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
