package frc.robot.enums;

public enum LedEnums {
    RainbowPalette(-0.99),PartyPalette(-0.97),OceanPalette(-0.95),
    LavePalette(-0.93),ForestPalette(-0.91),RainbowWithGlitter(-0.89),
    Confetti(-0.87),ShotRed(-0.85),ShotBlue(-0.83),
    ShotWhite(-0.81),SinelonRainbowPalette(-0.79),SinelonParty(-0.77),
    SinelonOcean(-0.75),SinelonLava (-0.73),SinelonForest(-0.71),
    BeatsPerMinuteRainbow(-0.69),BeatsPerMinuteParty(-0.67),BeatsPerMinuteOcean(-0.65),
    BeatsPerMinuteLava(-0.63),BeatsPerMinuteForest(-0.61),FireMedium(-0.59),
    FireLarge(-0.57),TwinklesRainbow(-0.55),TwinklesPartyPalette(-0.53),
    TwinklesOceanPalette(-0.51),TwinklesLavaPalette(-0.49),TwinklesForestPalette(-0.47),
    ColorWavesRainbowPalette(-0.45),ColorWavesPartyPalette(-0.43),ColorWavesOceanPalette(-0.41),
    ColorWavesLavaPalette(-0.39),ColorWavesForestPalette(-0.37),LarsonScannerRed(-0.35),
    LarsonScannerGray(-0.33),LightChaseRed(-0.31),LightChaseBlue(-0.29),
    LightChaseGray(-0.27),HeartbeatRed(-0.25),HeartbeatBlue(-0.23),
    HeartbeatWhite(-0.21),HeartbeatGray(-0.19),BreathRed(-0.17),
    BreathBlue(-0.15),BreathGray(-0.13),StrobeRed(-0.11),
    StrobeBlue(-0.09),StrobeGold(-0.07),StrobeWhite(-0.05),
    ColorOneEndToEndBlendToBlack(-0.03),LarsonScannerPatternWidth(-0.01),LightChaseDimmingSpeed(0.01),
    ColorOneHeartbeatSlow(0.03),ColorOneHeartbeatMedium(0.05),ColorOneHeartbeatFast(0.07),
    ColorOneBreathSlow(0.09),ColorOneBreathFast(0.11),ColorOneShot(0.13),
    ColorOneStrobe(0.15),ColorTwoEndToEndBlendToBlack(0.17),ColorTwoLarsonScannerPattern(0.19),
    ColorTwoLightChaseDimming (0.21),ColorTwoHeartbeatSlow(0.23),ColorTwoHeartbeatMedium(0.25),
    ColorTwoHeartbeatFast(0.27),ColorTwoBreathSlow(0.29),ColorTwoBreathFast(0.31),
    ColorTwoShot(0.33),ColorTwoStrobe(0.35),SparkleOnColorTwo(0.37),
    SparkleOnColorOne(0.39),ColorGradient (0.41),BeatsPerMinute (0.43),
    EndToEndBlendColorOneToColorTwo(0.45),EndToEndBlend(0.47),ColorOneAndTwoNoBlending(0.49),
    Twinkles (0.51),ColorWaves (0.53),Sinelon (0.55),
    HotPink(0.57),Darkred(0.59),Red(0.61),
    RedOrange(0.63),Orange(0.65),Gold(0.67),
    Yellow(0.69),LawnGreen(0.71),Lime(0.73),
    DarkGreen(0.75),Green(0.77),BlueGreen(0.79),
    Aqua(0.81),SkyBlue(0.83),DarkBlue(0.85),
    Blue(0.87),BlueViolet(0.89),Violet(0.91),
    White(0.93),Gray(0.95),DarkGray(0.97),Black(0.99);

    private Double level;

    public Double getLevel() {
        return this.level;
    }

    private LedEnums(Double level) {
        this.level = level;
    }

}
