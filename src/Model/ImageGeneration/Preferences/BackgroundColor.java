package Model.ImageGeneration.Preferences;

public enum BackgroundColor {

    DARK_GRAY("dgrey"),
    GRAY("grey"),
    SILVER("silver"),
    YELLOW("yellow"),
    RED("red"),
    ORANGE("orange"),
    BLUE("blue"),
    GREEN("green"),
    PURPLE("purple"),
    PINK("pink"),
    WHITE("white"),
    BLACK("black"),
    TRANSPARENT("t");

    private final String color;

    BackgroundColor(String s) {
        color = s;
    }

    @Override
    public String toString() {
        return this.color;
    }
}
