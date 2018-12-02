package Model.ImageGeneration.Preferences;

public class SizeAttribute extends Attribute {

    SizeAttribute(Integer size) {
        super(size.toString());
    }

    SizeAttribute() {
        this(250);
    }

    @Override
    String getIdentifier() {
        return "size";
    }
}
