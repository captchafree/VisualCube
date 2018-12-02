package ImageGeneration.Attributes;

import ImageGeneration.Exceptions.PuzzleTypeOutOfBoundsException;

class PuzzleTypeAttribute extends Attribute {

    PuzzleTypeAttribute(Integer size) {
        super(isValid(size));
    }

    @Override
    String getIdentifier() {
        return "pzl";
    }

    private static String isValid(Integer size) {
        if (size < 1 || size > 10) {
            throw new PuzzleTypeOutOfBoundsException("A puzzle type must be an integer between 1 and 10");
        }
        return size.toString();
    }
}
