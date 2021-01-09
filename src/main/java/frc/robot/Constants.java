/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Drivetrain motors and encoders
    public static final int DRIVE_FR = 1;
    public static final int DRIVE_RR = 2;
    public static final int DRIVE_FL = 3;
    public static final int DRIVE_RL = 4;
    public static final int DRIVE_ENCODER_R = 2;
    public static final int DRIVE_ENCODER_L = 4;

    // Shooter motors
    public static final int SHOOTER_R = 5;
    public static final int SHOOTER_L = 6;
    public static final int SHOOTER_F = 10;
    
    // Intake motor
    public static final int COLLECTOR = 7;

    // Hopper motors
    public static final int HOPPER_R = 8;
    public static final int HOPPER_L = 9;

    // Climber motor
    public static final int CLIMBER = 11;

    // Gamepad
    public static final int GAMEPAD = 0;
}
