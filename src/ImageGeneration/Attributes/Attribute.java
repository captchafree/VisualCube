package ImageGeneration.Attributes;

abstract class Attribute {

    private String value;

    Attribute(Object value) {
        this.value = validateInput(value);
    }

    abstract String getIdentifier();

    protected abstract String validateInput(Object input);

    String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getIdentifier() + "=" + this.value;
    }
}
