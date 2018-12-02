package ImageGeneration.Attributes;

class BackgroundColorAttribute extends Attribute {

    BackgroundColorAttribute(BackgroundColor color) {
        super(color);
    }

    BackgroundColorAttribute() {
        this(BackgroundColor.WHITE);
    }

    @Override
    String getIdentifier() {
        return "bg";
    }

    @Override
    protected String validateInput(Object input) {
        BackgroundColor color = (BackgroundColor) input;
        return color.toString();
    }
}