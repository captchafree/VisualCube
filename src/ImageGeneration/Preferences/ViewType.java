package ImageGeneration.Preferences;

public enum ViewType {

    TRANSPARENT("trans"),
    PLANAR("plan");

    private final String view;

    ViewType(String s) {
        view = s;
    }

    @Override
    public String toString() {
        return this.view;
    }
}
