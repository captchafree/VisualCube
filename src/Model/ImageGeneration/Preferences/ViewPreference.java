package Model.ImageGeneration.Preferences;

public class ViewPreference extends Preference {

    public ViewPreference(ViewType view) {
        super(view.toString());
    }

    @Override
    public String getIdentifier() {
        return "view";
    }
}
