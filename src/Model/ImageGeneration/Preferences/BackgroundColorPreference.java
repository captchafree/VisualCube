package Model.ImageGeneration.Preferences;

class BackgroundColorPreference extends Preference {

    BackgroundColorPreference(BackgroundColor color) {
        super(color.toString());
    }

    BackgroundColorPreference() {
        this(BackgroundColor.WHITE);
    }

    @Override
    String getIdentifier() {
        return "bg";
    }
}