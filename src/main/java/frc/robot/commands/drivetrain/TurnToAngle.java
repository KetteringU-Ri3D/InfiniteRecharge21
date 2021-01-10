/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class TurnToAngle extends PIDCommand {
  /**
   * Creates a new TurnToAngle.
   */
  public TurnToAngle(Drivetrain drivetrain, double targetAngle) {
    super(
        new PIDController(Constants.kP, Constants.kI, Constants.kD),
        // Close the loop on the heading
        drivetrain::getHeading,
        // Set the reference angle to the target angle
        targetAngle,
        // Turn the robot
        output -> drivetrain.arcadeDrive(0, output),
        // Requires drivetrain to use
        drivetrain
    );

    // Set the gyro to be continuous
    getController().enableContinuousInput(-180, 180);

    getController().setTolerance(Constants.kTurnTolerance, Constants.kTurnRateTolerance);
  }

  // End the command when target angle = reference angle
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
