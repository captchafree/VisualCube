package Model.ImageGeneration.Preferences;

public class CasePreference extends Preference {

    public CasePreference(String algorithm) {
        super(algorithm);
    }

    @Override
    public String getIdentifier() {
        return "case";
    }
}
