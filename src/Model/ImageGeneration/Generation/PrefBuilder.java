package Model.ImageGeneration.Generation;

import Model.ImageGeneration.Preferences.*;

import java.io.Serializable;
import java.util.HashMap;

public class PrefBuilder implements Serializable {

    private static final long serialVersionUID = 1L;

    private HashMap<Class, Preference> preferences;

    public PrefBuilder() {
        preferences = new HashMap<>();
    }

    public PrefBuilder algorithm(String algorithm) {
        preferences.put(AlgorithmPreference.class, new AlgorithmPreference(algorithm));
        return this;
    }

    public PrefBuilder fileType(FileType fileType) {
        preferences.put(FileTypePreference.class, new FileTypePreference(fileType));
        return this;
    }

    public PrefBuilder imageSize(Integer size) {
        preferences.put(SizePreference.class, new SizePreference(size));
        return this;
    }

    public PrefBuilder backgroundColor(BackgroundColor color) {
        preferences.put(BackgroundColorPreference.class, new BackgroundColorPreference(color));
        return this;
    }

    public PrefBuilder puzzleType(Integer size) {
        preferences.put(PuzzleTypePreference.class, new PuzzleTypePreference(size));
        return this;
    }

    public PrefBuilder algorithmCase(String algorithm) {
        preferences.put(CasePreference.class, new CasePreference(algorithm));
        return this;
    }

    public PrefBuilder stageMask(StageMaskType mask) {
        preferences.put(StageMaskType.class, new StageMaskPreference(mask));
        return this;
    }

    public PrefBuilder view(ViewType view) {
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
