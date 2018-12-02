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
        private FileTypePreference fileTypePreferred;

        public Builder() {
            preferences = new HashMap<>();

            //Default file type is PNG
            fileTypePreferred = new FileTypePreference(FileType.PNG);
        }

        //TODO: Replace numbers >4 with that number % 4
        private boolean verifyAlgorithmm(String algorithm) {
            String validCharacters = "UDFBLRSEM";
            validCharacters += validCharacters.toLowerCase() + "'23";

            return algorithm.matches("[" + validCharacters + "]*");
        }

        public Builder algorithm(String algorithm) {
            if(algorithm == null) {
                return this;
            }
            algorithm = algorithm.replace(" ", "");
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
            if(fileType == null) {
                return this;
            }

            fileTypePreferred = new FileTypePreference(fileType);
            return this;
        }

        public Builder imageSize(Integer size) {
            if(size == null) {
                return this;
            }

            if (size < 0 || size > 1024) {
                throw new SizeOutOfBoundsException("An image's size must be a value between 1 and 1024");
            }
            preferences.put(SizePreference.class, new SizePreference(size));
            return this;
        }

        public Builder backgroundColor(BackgroundColor color) {
            if(color == null) {
                return this;
            }

            preferences.put(BackgroundColorPreference.class, new BackgroundColorPreference(color));
            return this;
        }

        public Builder puzzleType(Integer size) {
            if(size == null) {
                return this;
            }

            if (size < 1 || size > 10) {
                throw new PuzzleTypeOutOfBoundsException("A puzzle type must be an integer between 1 and 10");
            }
            preferences.put(PuzzleTypePreference.class, new PuzzleTypePreference(size));
            return this;
        }

        public Builder algorithmCase(String algorithm) {
            if(algorithm == null) {
                return this;
            }
            algorithm = algorithm.replace(" ", "");
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
            if(mask == null) {
                return this;
            }

            preferences.put(StageMaskType.class, new StageMaskPreference(mask));
            return this;
        }

        public Builder view(ViewType view) {
            if(view == null) {
                return this;
            }

            preferences.put(ViewPreference.class, new ViewPreference(view));
            return this;
        }

        public CubeImagePreferences build() {
            CubeImagePreferences pref = new CubeImagePreferences();
            pref.preferences = this.preferences;
            pref.fileTypePreferred = this.fileTypePreferred;
            return pref;
        }
    }

    private HashMap<Class, Preference> preferences;
    private FileTypePreference fileTypePreferred;

    private CubeImagePreferences() {}

    @Override
    public String toString() {
        Preference[] prefs = preferences.values().toArray(new Preference[0]);
        String[] terms = new String[prefs.length + 1];

        for(int i = 0; i < prefs.length; i++) {
            terms[i] = prefs[i].toString();
        }
        terms[terms.length - 1] = fileTypePreferred.toString() + "." + fileTypePreferred.getValue();

        String result = String.join("&", terms);

        return result;
    }

    public String getFileExtension() {
        return fileTypePreferred.getValue();
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

    //====================================Setters====================================

    //TODO: Replace numbers >4 with that number % 4
    private boolean verifyAlgorithmm(String algorithm) {
        String validCharacters = "UDFBLRSEM";
        validCharacters += validCharacters.toLowerCase() + "'23";

        return algorithm.matches("[" + validCharacters + "]*");
    }

    public void algorithm(String algorithm) {
        if(algorithm == null) {
            return;
        }
        algorithm = algorithm.replace(" ", "");
        if (!verifyAlgorithmm(algorithm)) {
            String validCharacters = "UDFBLRSEM";
            validCharacters += validCharacters.toLowerCase() + "'23";

            throw new InvalidAlgorithmException("An algorithm case can consist of only the characters in the set {" +
                    validCharacters.join(", ", validCharacters.split("")) + "}");
        }
        preferences.put(AlgorithmPreference.class, new AlgorithmPreference(algorithm));
        return;
    }

    public void fileType(FileType fileType) {
        if(fileType == null) {
            return;
        }

        fileTypePreferred = new FileTypePreference(fileType);
        return;
    }

    public void imageSize(Integer size) {
        if(size == null) {
            return;
        }

        if (size < 0 || size > 1024) {
            throw new SizeOutOfBoundsException("An image's size must be a value between 1 and 1024");
        }
        preferences.put(SizePreference.class, new SizePreference(size));
        return;
    }

    public void backgroundColor(BackgroundColor color) {
        if(color == null) {
            return;
        }

        preferences.put(BackgroundColorPreference.class, new BackgroundColorPreference(color));
        return;
    }

    public void puzzleType(Integer size) {
        if(size == null) {
            return;
        }

        if (size < 1 || size > 10) {
            throw new PuzzleTypeOutOfBoundsException("A puzzle type must be an integer between 1 and 10");
        }
        preferences.put(PuzzleTypePreference.class, new PuzzleTypePreference(size));
        return;
    }

    public void algorithmCase(String algorithm) {
        if(algorithm == null) {
            return;
        }
        algorithm = algorithm.replace(" ", "");
        System.out.println(algorithm);
        if (!verifyAlgorithmm(algorithm)) {
            String validCharacters = "UDFBLRSEM";
            validCharacters += validCharacters.toLowerCase() + "'23";

            throw new InvalidCaseException("An algorithm case can consist of only the characters in the set {" +
                    validCharacters.join(", ", validCharacters.split("")) + "}");
        }
        preferences.put(CasePreference.class, new CasePreference(algorithm));
        return;
    }

    public void stageMask(StageMaskType mask) {
        if(mask == null) {
            return;
        }

        preferences.put(StageMaskType.class, new StageMaskPreference(mask));
        return;
    }

    public void view(ViewType view) {
        if(view == null) {
            return;
        }

        preferences.put(ViewPreference.class, new ViewPreference(view));
        return;
    }
}
