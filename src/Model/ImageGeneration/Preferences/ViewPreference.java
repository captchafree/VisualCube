package Model.ImageGeneration.Preferences;

class ViewPreference extends Preference {

    ViewPreference(ViewType view) {
        super(view.toString());
    }

    @Override
    String getIdentifier() {
        return "view";
    }
}
