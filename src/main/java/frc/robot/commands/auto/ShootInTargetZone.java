/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.collector.CollectorArmOut;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.commands.shooter.Shoot;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ShootInTargetZone extends SequentialCommandGroup {
/**
   * Autonomous command to drive off the initiation line into the target zone,
   * shoot, and then drive into mid-field
   */
  public ShootInTargetZone(Drivetrain drivetrain, Shooter shooter, Hopper hopper, Collector collector, Feeder feeder) {
    super(
      new ArcadeDrive(drivetrain, () -> 0.5, () -> 0).withTimeout(3).alongWith(
        new CollectorArmOut(collector).withTimeout(0.5)
      ),
      new Shoot(
        shooter, 
        // Shooter power
        () -> 0.75, 
        hopper, 
        // Hopper power left
        () -> 0.5, 
        // Hopper power right
        () -> 0.7, 
        collector, 
        // Collector power
        () -> 0.85, 
        // Feeder power
        feeder,
        () -> 0.5
      ).withTimeout(7),
      new ArcadeDrive(drivetrain, () -> -0.5, () -> 0).withTimeout(4)
    );

    /*
    super(
      new CollectorArmOut(collector),
      new Shoot(
        shooter, 
        // Shooter power
        () -> 0.75, 
        hopper, 
        // Hopper power left
        () -> 0.5, 
        // Hopper power right
        () -> 0.7, 
        collector, 
        // Collector power
        () -> 0.85, 
        // Feeder power
        feeder,
        () -> 0.5
      ).alongWith(
      new ArcadeDrive(drivetrain, () -> 0.5, () -> 0).withTimeout(3)),
      
      new ArcadeDrive(drivetrain, () -> -0.5, () -> 0).withTimeout(4)
    );
    */

  }
}
