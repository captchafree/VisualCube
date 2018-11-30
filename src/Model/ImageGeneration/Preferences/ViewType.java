package Model.ImageGeneration.Preferences;

import java.io.Serializable;

public enum ViewType implements Serializable {

    TRANSPARENT("trans"),
    PLANAR("plan");

    private final String name;

    ViewType(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
