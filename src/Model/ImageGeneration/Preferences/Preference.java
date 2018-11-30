package Model.ImageGeneration.Preferences;

import java.io.Serializable;

public abstract class Preference implements Serializable {

    private static final long serialVersionUID = 1L;

    private String value;

    public Preference(String value) {
        this.value = value;
    }

    public abstract String getIdentifier();

    public String getValue() {
        return this.value;
    }
}
