package Model.ImageGeneration.Generation;

import Model.ImageGeneration.Preferences.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class CubeImagePreferences implements Serializable {

    public static class Builder implements Serializable {

        private static final long serialVersionUID = 1L;

        private HashMap<Class, Preference> preferences;

        public Builder() {
            preferences = new HashMap<>();
        }

        public Builder algorithm(String algorithm) {
            preferences.put(AlgorithmPreference.class, new AlgorithmPreference(algorithm));
            return this;
        }

        public Builder fileType(FileType fileType) {
            preferences.put(FileTypePreference.class, new FileTypePreference(fileType));
            return this;
        }

        public Builder imageSize(Integer size) {
            preferences.put(SizePreference.class, new SizePreference(size));
            return this;
        }

        public Builder backgroundColor(BackgroundColor color) {
            preferences.put(BackgroundColorPreference.class, new BackgroundColorPreference(color));
            return this;
        }

        public Builder puzzleType(Integer size) {
            preferences.put(PuzzleTypePreference.class, new PuzzleTypePreference(size));
            return this;
        }

        public Builder algorithmCase(String algorithm) {
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
            if(preferences.size() == 0) {
                preferences.put(FileTypePreference.class, new FileTypePreference(FileType.PNG));
            }

            pref.preferences = this.preferences;
            return pref;
        }
    }

    private static final long serialVersionUID = 1L;

    public HashMap<Class, Preference> preferences;

    public CubeImagePreferences() {}

    @Override
    public String toString() {
        String result = "";

        Preference[] prefs = preferences.values().toArray(new Preference[0]);

        FileTypePreference filePref = null;
        for(int i = 0; i < prefs.length; i++) {
            if(i != 0) {
                result += "&";
            }

            if(!(prefs[i] instanceof FileTypePreference)) {
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
