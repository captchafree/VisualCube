package Model.ImageGeneration.Preferences;

class CasePreference extends Preference {

    CasePreference(String algorithm) {
        super(algorithm);
    }

    @Override
    String getIdentifier() {
        return "case";
    }
}
