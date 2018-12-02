package ImageGeneration.Preferences;

class PuzzleTypeAttribute extends Attribute {

    PuzzleTypeAttribute(Integer size) {
        super(size.toString());
    }

    @Override
    String getIdentifier() {
        return "pzl";
    }
}
