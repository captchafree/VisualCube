package Model.ImageGeneration.Preferences;

public class StageMaskPreference extends Preference {

    public StageMaskPreference(StageMaskType mask) {
        super(mask.name().toLowerCase());
    }

    @Override
    public String getIdentifier() {
        return "stage";
    }
}
