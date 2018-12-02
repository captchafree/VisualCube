package ImageGeneration.Attributes;

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
