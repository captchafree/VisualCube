package ImageGeneration.Preferences;

class ViewAttribute extends Attribute {

    ViewAttribute(ViewType view) {
        super(view.toString());
    }

    @Override
    String getIdentifier() {
        return "view";
    }
}
