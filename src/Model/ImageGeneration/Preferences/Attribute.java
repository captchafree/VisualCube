package Model.ImageGeneration.Preferences;

abstract class Attribute {

    private String value;

    Attribute(String value) {
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
