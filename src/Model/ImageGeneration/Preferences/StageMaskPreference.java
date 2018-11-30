package Model.ImageGeneration.Preferences;

class StageMaskPreference extends Preference {

    StageMaskPreference(StageMaskType mask) {
        super(mask.name().toLowerCase());
    }

    @Override
    String getIdentifier() {
        return "stage";
    }
}
