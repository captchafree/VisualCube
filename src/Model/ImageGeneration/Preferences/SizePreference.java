package Model.ImageGeneration.Preferences;

public class SizePreference extends Preference {

    SizePreference(Integer size) {
        super(size.toString());
    }

    SizePreference() {
        this(250);
    }

    @Override
    String getIdentifier() {
        return "size";
    }
}
