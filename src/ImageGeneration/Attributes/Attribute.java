package ImageGeneration.Attributes;

import ImageGeneration.Exceptions.InvalidAttributeException;

abstract class Attribute implements Comparable<Attribute> {

    private String value;

    Attribute(Object value) {
        this.value = validateInput(value);
    }

    /**
     * Returns the id of the attribute.
     * @return
     */
    abstract String getIdentifier();

    /**
     * Converts the input into a usable form.
     * @param input The input to be validated and converted into a String.
     * @return A String representation of the input.
     * @throws InvalidAttributeException Thrown if the input is invalid.
     */
    protected abstract String validateInput(Object input) throws InvalidAttributeException;

    String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getIdentifier() + "=" + this.value;
    }

    @Override
    public int compareTo(Attribute other) {
        return this.getIdentifier().compareTo(other.getIdentifier());
    }
}
