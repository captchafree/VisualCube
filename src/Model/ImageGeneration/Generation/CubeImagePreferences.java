package Model.ImageGeneration.Generation;

import Model.ImageGeneration.Preferences.*;

import java.io.Serializable;
import java.util.HashMap;

public class CubeImagePreferences implements Serializable {

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
}
