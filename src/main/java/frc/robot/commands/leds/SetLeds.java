package frc.robot.commands.leds;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.enums.LedEnums;
import frc.robot.subsystems.Led;

public class SetLeds extends CommandBase {

    public Led ledSubsystem;

    public SetLeds(LedEnums ledEnumValue) {
        ledSubsystem = new Led(9);
        ledSubsystem.set(ledEnumValue);
    }
    
}
