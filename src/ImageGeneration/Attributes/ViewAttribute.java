package ImageGeneration.Attributes;

class ViewAttribute extends Attribute {

    ViewAttribute(ViewType view) {
        super(view);
    }

    @Override
    String getIdentifier() {
        return "view";
    }

    @Override
    protected String validateInput(Object input) {
        ViewType view = (ViewType) input;
        return view.toString();
    }
}
