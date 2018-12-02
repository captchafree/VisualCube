package Model.ImageGeneration.Preferences;

class CaseAttribute extends Attribute {

    CaseAttribute(String algorithm) {
        super(algorithm);
    }

    @Override
    String getIdentifier() {
        return "case";
    }
}
