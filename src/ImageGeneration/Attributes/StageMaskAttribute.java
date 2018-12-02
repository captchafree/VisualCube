package ImageGeneration.Attributes;

class StageMaskAttribute extends Attribute {

    StageMaskAttribute(StageMaskType mask) {
        super(mask);
    }

    @Override
    String getIdentifier() {
        return "stage";
    }

    @Override
    protected String validateInput(Object input) {
        StageMaskType mask = (StageMaskType) input;
        return mask.name().toLowerCase();
    }
}
