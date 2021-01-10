/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.hopper.HopperIn;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Shoot extends ParallelCommandGroup {
  static Shooter shooter;
  static Hopper hopper;
  // static Collector collector;          // UNCOMMENT IF COLLECTOR IS NEEDED TO SHOOT
  static double shooterPower = 0.5,
                hopperPower = 0.5,
                /*collectorPower = 0.5,*/ // UNCOMMENT IF COLLECTOR IS NEEDED TO SHOOT
                feederPower = 0.5;


  /**
   * Shoot command, allows the driver to score power cells with a single button
   * press rather than multiple
   */
  public Shoot() {
    super(
      new ShooterOut(shooter, () -> shooterPower), 
      new HopperIn(hopper, () -> hopperPower), 
      // new Collect(collector, collectorPower),
      new FeederIn(shooter, () -> feederPower)
    );
  }
}
