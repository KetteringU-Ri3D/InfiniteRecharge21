package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.enums.LedEnums;

public class Led extends SubsystemBase {
    private static Spark blinkin = null;
        
    public Led(int pwmPort) {
        blinkin = new Spark(pwmPort);
        this.set(LedEnums.Aqua);
    }

    public void set(LedEnums num) {
        this.set(num.getLevel());
    }

    public void set(Double value) {
        if ((value >= -1.0) && (value <= 1.0)) {
            blinkin.set(value);
        }        
    }

}
