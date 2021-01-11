/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.collector.Collect;
import frc.robot.commands.hopper.HopperIn;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Shoot extends ParallelCommandGroup {
  Shooter shooter;
  Hopper hopper;
  Collector collector;

  /**
   * Shoot command, allows the driver to score power cells with a single button
   * press rather than multiple
   */
  public Shoot(Shooter shooter, DoubleSupplier shooterPower, Hopper hopper, 
               DoubleSupplier hopperPowerLeft, DoubleSupplier hopperPowerRight,
               Collector collector, DoubleSupplier collectorPower,
               DoubleSupplier feederPower) {
    super(
      new ShooterOut(shooter, shooterPower), 
      new WaitCommand(1.5), 
      new HopperIn(hopper, hopperPowerLeft, hopperPowerRight), 
      new Collect(collector, collectorPower),
      new FeederIn(shooter, feederPower)
    );
    this.shooter = shooter;
    this.hopper = hopper;
    this.collector = collector;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.shooterStop();
    hopper.hopperStop();
    collector.stopCollector();
  }
}
