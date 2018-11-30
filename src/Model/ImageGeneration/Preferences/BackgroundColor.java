package Model.ImageGeneration.Preferences;

import java.io.Serializable;

public enum BackgroundColor implements Serializable {

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

    private final String name;

    BackgroundColor(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
