package Model.ImageGeneration.Preferences;

class AlgorithmPreference extends Preference {

    AlgorithmPreference(String algorithm) {
        super(algorithm);
    }

    @Override
    String getIdentifier() {
        return "alg";
    }
}
