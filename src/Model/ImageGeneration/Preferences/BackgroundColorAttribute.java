package Model.ImageGeneration.Preferences;

class BackgroundColorAttribute extends Attribute {

    BackgroundColorAttribute(BackgroundColor color) {
        super(color.toString());
    }

    BackgroundColorAttribute() {
        this(BackgroundColor.WHITE);
    }

    @Override
    String getIdentifier() {
        return "bg";
    }
}