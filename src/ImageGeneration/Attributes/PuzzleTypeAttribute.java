package ImageGeneration.Attributes;

import ImageGeneration.Exceptions.PuzzleTypeOutOfBoundsException;

class PuzzleTypeAttribute extends Attribute {

    PuzzleTypeAttribute(Integer size) {
        super(size);
    }

    @Override
    String getIdentifier() {
        return "pzl";
    }

    @Override
    protected String validateInput(Object input) {
        Integer size = (Integer) input;
        if (size < 1 || size > 10) {
            throw new PuzzleTypeOutOfBoundsException("A puzzle type must be an integer between 1 and 10");
        }
        return size.toString();
    }
}
