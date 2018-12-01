package Model.ImageGeneration.Preferences;

import Model.ImageGeneration.Exceptions.InvalidAlgorithmException;
import Model.ImageGeneration.Exceptions.InvalidCaseException;
import Model.ImageGeneration.Exceptions.PuzzleTypeOutOfBoundsException;
import Model.ImageGeneration.Exceptions.SizeOutOfBoundsException;

import java.util.HashMap;

//TODO: Add more preferences
public class CubeImagePreferences {

    public static class Builder {

        private HashMap<Class, Preference> preferences;

        public Builder() {
            preferences = new HashMap<>();
        }

        //TODO: Replace numbers >4 with that number % 4
        private boolean verifyAlgorithmm(String algorithm) {
            String validCharacters = "UDFBLRSEM";
            validCharacters += validCharacters.toLowerCase() + "'23";

            return algorithm.matches("[" + validCharacters + "]*");
        }

        public Builder algorithm(String algorithm) {
            if (!verifyAlgorithmm(algorithm)) {
                String validCharacters = "UDFBLRSEM";
                validCharacters += validCharacters.toLowerCase() + "'23";

                throw new InvalidAlgorithmException("An algorithm case can consist of only the characters in the set {" +
                        validCharacters.join(", ", validCharacters.split("")) + "}");
            }
            preferences.put(AlgorithmPreference.class, new AlgorithmPreference(algorithm));
            return this;
        }

        public Builder fileType(FileType fileType) {
            preferences.put(FileTypePreference.class, new FileTypePreference(fileType));
            return this;
        }

        public Builder imageSize(Integer size) {
            if (size < 0 || size > 1024) {
                throw new SizeOutOfBoundsException("An image's size must be a value between 1 and 1024");
            }
            preferences.put(SizePreference.class, new SizePreference(size));
            return this;
        }

        public Builder backgroundColor(BackgroundColor color) {
            preferences.put(BackgroundColorPreference.class, new BackgroundColorPreference(color));
            return this;
        }

        public Builder puzzleType(Integer size) {
            if (size < 1 || size > 10) {
                throw new PuzzleTypeOutOfBoundsException("A puzzle type must be an integer between 1 and 10");
            }
            preferences.put(PuzzleTypePreference.class, new PuzzleTypePreference(size));
            return this;
        }

        public Builder algorithmCase(String algorithm) {
            if (!verifyAlgorithmm(algorithm)) {
                String validCharacters = "UDFBLRSEM";
                validCharacters += validCharacters.toLowerCase() + "'23";

                throw new InvalidCaseException("An algorithm case can consist of only the characters in the set {" +
                        validCharacters.join(", ", validCharacters.split("")) + "}");
            }
            preferences.put(CasePreference.class, new CasePreference(algorithm));
            return this;
        }

        public Builder stageMask(StageMaskType mask) {
            preferences.put(StageMaskType.class, new StageMaskPreference(mask));
            return this;
        }

        public Builder view(ViewType view) {
            preferences.put(ViewPreference.class, new ViewPreference(view));
            return this;
        }

        public CubeImagePreferences build() {
            CubeImagePreferences pref = new CubeImagePreferences();

            //There must be at least one preference to generate an image
            if (preferences.size() == 0) {
                preferences.put(FileTypePreference.class, new FileTypePreference(FileType.PNG));
            }

            pref.preferences = this.preferences;
            return pref;
        }
    }

    private HashMap<Class, Preference> preferences;

    private CubeImagePreferences() {}

    @Override
    public String toString() {
        String result = "";

        Preference[] prefs = preferences.values().toArray(new Preference[0]);

        FileTypePreference filePref = null;
        for (int i = 0; i < prefs.length; i++) {
            if (i != 0) {
                result += "&";
            }

            if (!(prefs[i] instanceof FileTypePreference)) {
                result += prefs[i].getIdentifier() + "=" + prefs[i].getValue();
            } else {
                filePref = (FileTypePreference) prefs[i];
                result = result.substring(0, result.length() - 1);
            }
        }

        result += "&" + filePref.getIdentifier() + "=" + filePref.getValue();

        //Add the extension
        result += "." + preferences.get(FileTypePreference.class).getValue();

        return result;
    }

    public String getFileExtension() {
        return preferences.get(FileTypePreference.class).getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeImagePreferences that = (CubeImagePreferences) o;
        return that.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
