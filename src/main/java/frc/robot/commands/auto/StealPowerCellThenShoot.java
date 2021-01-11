/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveAndCollect;
import frc.robot.commands.drivetrain.ArcadeDrive;
// import frc.robot.commands.drivetrain.TurnToAngle;
import frc.robot.commands.shooter.Shoot;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class StealPowerCellThenShoot extends SequentialCommandGroup {
  private static Drivetrain drivetrain;
  
  /**
   * Autonomous command to drive off the initiation line into the opposing
   * trench run, steal a power cell, then drive to the target zone and shoot
   */
  public StealPowerCellThenShoot() {
    super(
      new DriveAndCollect(1, 0, 0.5).withTimeout(1.5),
      new ArcadeDrive(drivetrain, () -> -1, () -> 0).withTimeout(4),
      // new TurnToAngle(drivetrain, -90),
      new ArcadeDrive(drivetrain, () -> 0.75, () -> 0).withTimeout(4.5),
      // new TurnToAngle(drivetrain, -90),
      new ArcadeDrive(drivetrain, () -> 0.5, () -> 0).withTimeout(2),
      new Shoot()
    );
  }
}