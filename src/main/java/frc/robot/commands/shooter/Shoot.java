// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooter;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Shoot extends SequentialCommandGroup {
  /** Creates a new Shoot. */
  public Shoot(
    Shooter shooter, DoubleSupplier shooterPower,
    Hopper hopper, DoubleSupplier hopperPowerLeft, DoubleSupplier hopperPowerRight,
    Collector collector, DoubleSupplier collectorPower,
    Feeder feeder, DoubleSupplier feederPower) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ShooterOut(shooter, shooterPower), 
      new WaitCommand(1.5), 
      new FeedCellsToShooter(
        hopper, hopperPowerLeft, hopperPowerRight, 
        collector, collectorPower, 
        feeder, feederPower
      )
    );
  }
}
