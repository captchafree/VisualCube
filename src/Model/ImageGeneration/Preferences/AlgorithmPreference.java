package Model.ImageGeneration.Preferences;

public class AlgorithmPreference extends Preference {

    public AlgorithmPreference(String algorithm) {
        super(algorithm);
    }

    @Override
    public String getIdentifier() {
        return "alg";
    }
}
