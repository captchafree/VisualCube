package Model.ImageGeneration.Preferences;

abstract class Preference {

    private String value;

    Preference(String value) {
        this.value = value;
    }

    abstract String getIdentifier();

    String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getIdentifier() + "=" + this.value;
    }
}
