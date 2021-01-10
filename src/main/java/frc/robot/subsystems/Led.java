package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Led extends SubsystemBase {

    private final Double RainbowPalette = -0.99;
    private final Double PartyPalette = -0.97;
    private final Double OceanPalette = -0.95;
    private final Double LavePalette = -0.93;
    private final Double ForestPalette = -0.91;
    private final Double RainbowWithGlitter = -0.89;
    private final Double Confetti = -0.87;
    private final Double ShotRed = -0.85;
    private final Double ShotBlue = -0.83;
    private final Double ShotWhite = -0.81;
    private final Double SinelonRainbowPalette = -0.79;
    private final Double SinelonParty = -0.77;
    private final Double SinelonOcean = -0.75;
    private final Double SinelonLava  = -0.73;
    private final Double SinelonForest = -0.71;
    private final Double BeatsPerMinuteRainbow = -0.69;
    private final Double BeatsPerMinuteParty = -0.67;
    private final Double BeatsPerMinuteOcean = -0.65;
    private final Double BeatsPerMinuteLava = -0.63;
    private final Double BeatsPerMinuteForest = -0.61;
    private final Double FireMedium = -0.59;
    private final Double FireLarge = -0.57;
    private final Double TwinklesRainbow = -0.55;
    private final Double TwinklesPartyPalette = -0.53;
    private final Double TwinklesOceanPalette = -0.51;
    private final Double TwinklesLavaPalette = -0.49;
    private final Double TwinklesForestPalette = -0.47;
    private final Double ColorWavesRainbowPalette = -0.45;
    private final Double ColorWavesPartyPalette = -0.43;
    private final Double ColorWavesOceanPalette = -0.41;
    private final Double ColorWavesLavaPalette = -0.39;
    private final Double ColorWavesForestPalette = -0.37;
    private final Double LarsonScannerRed = -0.35;
    private final Double LarsonScannerGray = -0.33;
    private final Double LightChaseRed = -0.31;
    private final Double LightChaseBlue = -0.29;
    private final Double LightChaseGray = -0.27;
    private final Double HeartbeatRed = -0.25;
    private final Double HeartbeatBlue = -0.23;
    private final Double HeartbeatWhite = -0.21;
    private final Double HeartbeatGray = -0.19;
    private final Double BreathRed = -0.17;
    private final Double BreathBlue = -0.15;
    private final Double BreathGray = -0.13;
    private final Double StrobeRed = -0.11;
    private final Double StrobeBlue = -0.09;
    private final Double StrobeGold = -0.07;
    private final Double StrobeWhite = -0.05;
    private final Double ColorOneEndToEndBlendToBlack = -0.03;
    private final Double LarsonScannerPatternWidth = -0.01;
    private final Double LightChaseDimmingSpeed = 0.01;
    private final Double ColorOneHeartbeatSlow = 0.03;
    private final Double ColorOneHeartbeatMedium = 0.05;
    private final Double ColorOneHeartbeatFast = 0.07;
    private final Double ColorOneBreathSlow = 0.09;
    private final Double ColorOneBreathFast = 0.11;
    private final Double ColorOneShot = 0.13;
    private final Double ColorOneStrobe = 0.15;
    private final Double ColorTwoEndToEndBlendToBlack = 0.17;
    private final Double ColorTwoLarsonScannerPattern = 0.19;
    private final Double ColorTwoLightChaseDimming  = 0.21;
    private final Double ColorTwoHeartbeatSlow = 0.23;
    private final Double ColorTwoHeartbeatMedium = 0.25;
    private final Double ColorTwoHeartbeatFast = 0.27;
    private final Double ColorTwoBreathSlow = 0.29;
    private final Double ColorTwoBreathFast = 0.31;
    private final Double ColorTwoShot = 0.33;
    private final Double ColorTwoStrobe = 0.35;
    private final Double SparkleOnColorTwo = 0.37;
    private final Double SparkleOnColorOne = 0.39;
    private final Double ColorGradient  = 0.41;
    private final Double BeatsPerMinute  = 0.43;
    private final Double EndToEndBlendColorOneToColorTwo = 0.45;
    private final Double EndToEndBlend = 0.47;
    private final Double ColorOneAndTwoNoBlending = 0.49;
    private final Double Twinkles  = 0.51;
    private final Double ColorWaves  = 0.53;
    private final Double Sinelon  = 0.55;
    private final Double HotPink = 0.57;
    private final Double Darkred = 0.59;
    private final Double Red = 0.61;
    private final Double RedOrange = 0.63;
    private final Double Orange = 0.65;
    private final Double Gold = 0.67;
    private final Double Yellow = 0.69;
    private final Double LawnGreen = 0.71;
    private final Double Lime = 0.73;
    private final Double DarkGreen = 0.75;
    private final Double Green = 0.77;
    private final Double BlueGreen = 0.79;
    private final Double Aqua = 0.81;
    private final Double SkyBlue = 0.83;
    private final Double DarkBlue = 0.85;
    private final Double Blue = 0.87;
    private final Double BlueViolet = 0.89;
    private final Double Violet = 0.91;
    private final Double White = 0.93;
    private final Double Gray = 0.95;
    private final Double DarkGray = 0.97;
    private final Double Black = 0.99;

    private static Spark blinkin = null;
        
    public Led(int pwmPort) {
        blinkin = new Spark(pwmPort);
        this.set(this.Aqua);
    }

    public void set(double val) {
        if ((val >= -1.0) && (val <= 1.0)) {
            blinkin.set(val);
        }
    }

}
