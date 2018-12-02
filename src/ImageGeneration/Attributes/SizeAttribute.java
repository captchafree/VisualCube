package ImageGeneration.Attributes;

import ImageGeneration.Exceptions.SizeOutOfBoundsException;

public class SizeAttribute extends Attribute {

    SizeAttribute(Integer size) {
        super(size);
    }

    SizeAttribute() {
        this(250);
    }

    @Override
    String getIdentifier() {
        return "size";
    }

    @Override
    protected String validateInput(Object input) {
        Integer size = (Integer) input;

        if (size < 0 || size > 1024) {
            throw new SizeOutOfBoundsException("An image's size must be a value between 1 and 1024");
        }
        return size.toString();
    }
}
