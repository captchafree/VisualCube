package Model.ImageGeneration.Preferences;

public class SizePreference extends Preference {

    public SizePreference(Integer size) {
        super(size.toString());
    }

    public SizePreference() {
        this(250);
    }

    @Override
    public String getIdentifier() {
        return "size";
    }
}
