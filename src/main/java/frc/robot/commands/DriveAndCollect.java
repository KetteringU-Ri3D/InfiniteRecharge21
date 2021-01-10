/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.collector.Collect;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class DriveAndCollect extends ParallelCommandGroup {
  private static Drivetrain drivetrain;
  private static Collector collector;
  
  /**
   * Command to drive and collect power cells at the same time,
   * used in autonomous
   * Speed of moving forwards/backwards: @param throttle
   * Speed of rotation: @param rotation
   * Power applied to the collector motor: @param power
   */
  public DriveAndCollect(double throttle, double rotation, double power) {
    super(
      new ArcadeDrive(drivetrain, () -> throttle, () -> rotation),
      new Collect(collector, () -> power)
    );
  }
}
