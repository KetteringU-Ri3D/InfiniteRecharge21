/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  // Drivetrain motor controllers
  WPI_TalonSRX driveMotorFL = new WPI_TalonSRX(Constants.DRIVE_FL);
  WPI_VictorSPX driveMotorRL = new WPI_VictorSPX(Constants.DRIVE_RL);
  WPI_TalonSRX driveMotorFR = new WPI_TalonSRX(Constants.DRIVE_FR);
  WPI_VictorSPX driveMotorRR = new WPI_VictorSPX(Constants.DRIVE_RR);

  // Makes using DifferentialDrive easier
  SpeedControllerGroup driveLeft = new SpeedControllerGroup(driveMotorFL, driveMotorRL);
  SpeedControllerGroup driveRight = new SpeedControllerGroup(driveMotorFR, driveMotorRR);

  // Allows the use of built-in drive types, such as Arcade and Tank
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

    // Mag encoders
    driveMotorFL.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
                                              Constants.PID_LOOP_IDX,
                                              Constants.TIMEOUT_MS);
    driveMotorFR.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
                                              Constants.PID_LOOP_IDX,
                                              Constants.TIMEOUT_MS);

    // Setting each VictorSPX to follow the TalonSRX on the same side of the drivetrain
    driveMotorRL.follow(driveMotorFL);
    driveMotorRR.follow(driveMotorFR);
    // Set sensor phase to true, ensuring that the sensor value
    // is positive when the output value is positive
    driveMotorFL.setSensorPhase(Constants.SENSOR_PHASE);
    driveMotorFR.setSensorPhase(Constants.SENSOR_PHASE);

    // Reverse left drive encoder and leave right drive encoder as is
    driveMotorFL.setInverted(Constants.MOTOR_REVERSED);

    // Set peak and nominal outputs
    driveMotorFL.configNominalOutputForward(0, Constants.TIMEOUT_MS);
    driveMotorFL.configNominalOutputReverse(0, Constants.TIMEOUT_MS);
    driveMotorFL.configPeakOutputForward(1, Constants.TIMEOUT_MS);
    driveMotorFL.configPeakOutputReverse(-1, Constants.TIMEOUT_MS);
    driveMotorFR.configNominalOutputForward(0, Constants.TIMEOUT_MS);
    driveMotorFR.configNominalOutputReverse(0, Constants.TIMEOUT_MS);
    driveMotorFR.configPeakOutputForward(1, Constants.TIMEOUT_MS);
    driveMotorFR.configPeakOutputReverse(-1, Constants.TIMEOUT_MS);

    // Set allowable closed-loop error; output will be neutral in the range
    driveMotorFL.configAllowableClosedloopError(0, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);
    driveMotorFR.configAllowableClosedloopError(0, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);

    // Set closed loop position gains. kF is generally zero
    driveMotorFL.config_kF(Constants.PID_LOOP_IDX, Constants.gains.kF, Constants.TIMEOUT_MS);
    driveMotorFL.config_kP(Constants.PID_LOOP_IDX, Constants.gains.kP, Constants.TIMEOUT_MS);
    driveMotorFL.config_kI(Constants.PID_LOOP_IDX, Constants.gains.kI, Constants.TIMEOUT_MS);
    driveMotorFL.config_kD(Constants.PID_LOOP_IDX, Constants.gains.kD, Constants.TIMEOUT_MS);
    driveMotorFR.config_kF(Constants.PID_LOOP_IDX, Constants.gains.kF, Constants.TIMEOUT_MS);
    driveMotorFR.config_kP(Constants.PID_LOOP_IDX, Constants.gains.kP, Constants.TIMEOUT_MS);
    driveMotorFR.config_kI(Constants.PID_LOOP_IDX, Constants.gains.kI, Constants.TIMEOUT_MS);
    driveMotorFR.config_kD(Constants.PID_LOOP_IDX, Constants.gains.kD, Constants.TIMEOUT_MS);
    
    // Get the 360deg position of the encoder
    int absPosLeft = driveMotorFL.getSensorCollection().getPulseWidthPosition();
    int absPosRight = driveMotorFR.getSensorCollection().getPulseWidthPosition();

    // Keep bottom 12 bits only
    absPosLeft &= 0xFFF;
    if(Constants.SENSOR_PHASE) { absPosLeft *= -1; }
    if(Constants.MOTOR_REVERSED) { absPosLeft *= -1; }

    absPosRight &= 0xFFF;
    if(Constants.SENSOR_PHASE) { absPosRight *= -1; }
    if(Constants.MOTOR_REVERSED) { absPosRight *= -1; }

    // Match the relative sensor positions to the absolute positions
    driveMotorFL.setSelectedSensorPosition(absPosLeft, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);
    driveMotorFR.setSelectedSensorPosition(absPosRight, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);
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

  public void driveToPosition(int position) {
    driveMotorFL.set(ControlMode.Position, -position);
    driveMotorFR.set(ControlMode.Position, position);
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
