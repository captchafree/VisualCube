package ImageGeneration.Preferences;

class AlgorithmAttribute extends Attribute {

    AlgorithmAttribute(String algorithm) {
        super(algorithm);
    }

    @Override
    String getIdentifier() {
        return "alg";
    }
}
