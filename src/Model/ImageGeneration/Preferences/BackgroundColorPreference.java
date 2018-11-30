package Model.ImageGeneration.Preferences;

public class BackgroundColorPreference extends Preference {

    public BackgroundColorPreference(BackgroundColor color) {
        super(color.toString());
    }

    public BackgroundColorPreference() {
        this(BackgroundColor.WHITE);
    }

    @Override
    public String getIdentifier() {
        return "bg";
    }
}