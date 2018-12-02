package ImageGeneration.Attributes;

import ImageGeneration.Exceptions.InvalidAlgorithmException;

class AlgorithmAttribute extends Attribute {

    private static final String validCharacters = "UDFBLRSEMudfblrsemm'23xyz";

    AlgorithmAttribute(String algorithm) {
        super(algorithm);
    }

    @Override
    String getIdentifier() {
        return "alg";
    }

    @Override
    protected String validateInput(Object input) {
        String algorithm = (String) input;

        algorithm = algorithm.replace(" ", "");
        boolean isValid =  algorithm.matches("[" + validCharacters + "]*");
        if(!isValid) {
            throw new InvalidAlgorithmException("An algorithm can consist of only the characters in the set {" +
                    validCharacters.join(", ", validCharacters.split("")) + "}");
        }
        return algorithm;
    }
}
