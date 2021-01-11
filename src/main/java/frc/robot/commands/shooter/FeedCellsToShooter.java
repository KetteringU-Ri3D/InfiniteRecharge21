/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.collector.Collect;
import frc.robot.commands.feeder.FeederIn;
import frc.robot.commands.hopper.HopperIn;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Hopper;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class FeedCellsToShooter extends ParallelCommandGroup {
  Hopper hopper;
  Collector collector;
  Feeder feeder;

  /**
   * Shoot command, allows the driver to score power cells with a single button
   * press rather than multiple
   */
  public FeedCellsToShooter(
    Hopper hopper, DoubleSupplier hopperPowerLeft, DoubleSupplier hopperPowerRight,
    Collector collector, DoubleSupplier collectorPower,
    Feeder feeder, DoubleSupplier feederPower) {
    super(
      new HopperIn(hopper, hopperPowerLeft, hopperPowerRight), 
      new Collect(collector, collectorPower),
      new FeederIn(feeder, feederPower)
    );
    this.hopper = hopper;
    this.collector = collector;
    this.feeder = feeder;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    hopper.hopperStop();
    collector.stopCollector();
    feeder.feederStop();
  }
}
