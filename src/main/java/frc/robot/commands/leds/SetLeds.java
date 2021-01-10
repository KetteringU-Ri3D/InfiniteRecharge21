package frc.robot.commands.leds;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.enums.LedEnums;
import frc.robot.subsystems.Led;

public class SetLeds extends CommandBase {

    private final Led ledSubsystem;

    public SetLeds() {
        this.ledSubsystem = new Led(9);
        this.ledSubsystem.set(LedEnums.White);
    }

    public SetLeds(LedEnums ledEnumValue) {
        this.ledSubsystem = new Led(9);
        this.ledSubsystem.set(ledEnumValue);
    }

    public SetLeds(int pin) {
        this.ledSubsystem = new Led(pin);
        this.ledSubsystem.set(LedEnums.White);
    }

    public SetLeds(int pin, LedEnums ledEnumValue) {
        this.ledSubsystem = new Led(pin);
        this.ledSubsystem.set(ledEnumValue);
    }

    public void setLeds(LedEnums ledEnumValue) {
        this.ledSubsystem.set(ledEnumValue);
    }

    public void setLeds(Double ledDoubleValue) {
        this.ledSubsystem.set(ledDoubleValue);
    }
    
}
