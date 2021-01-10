/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.commands.shooter.Shoot;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ShootInTargetZone extends SequentialCommandGroup {
  private static Drivetrain drivetrain;
  
  /**
   * Autonomous command to drive off the initiation line into the target zone,
   * shoot, and then drive into mid-field
   */
  public ShootInTargetZone() {
    super(
      new ArcadeDrive(drivetrain, () -> 0.5, () -> 0).withTimeout(3),
      new Shoot().withTimeout(5),
      new ArcadeDrive(drivetrain, () -> -0.5, () -> 0).withTimeout(4)
    );
  }
}
