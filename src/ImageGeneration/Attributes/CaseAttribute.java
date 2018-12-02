package ImageGeneration.Attributes;

import ImageGeneration.Exceptions.InvalidCaseException;

class CaseAttribute extends Attribute {

    private static final String validCharacters = "UDFBLRSEMudfblrsemm'23xyz";

    CaseAttribute(String algorithm) {
        super(verifyAlgorithm(algorithm));
    }

    @Override
    String getIdentifier() {
        return "case";
    }

    private static String verifyAlgorithm(String algorithm) {
        algorithm = algorithm.replace(" ", "");
        boolean isValid =  algorithm.matches("[" + validCharacters + "]*");
        if(!isValid) {
            throw new InvalidCaseException("An algorithm case can consist of only the characters in the set {" +
                    validCharacters.join(", ", validCharacters.split("")) + "}");
        }
        return algorithm;
    }
}
