package ImageGeneration.Attributes;

class StageMaskAttribute extends Attribute {

    StageMaskAttribute(StageMaskType mask) {
        super(mask.name().toLowerCase());
    }

    @Override
    String getIdentifier() {
        return "stage";
    }
}
