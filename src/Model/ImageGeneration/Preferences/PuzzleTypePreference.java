package Model.ImageGeneration.Preferences;

public class PuzzleTypePreference extends Preference {

    public PuzzleTypePreference(Integer size) {
        super(size.toString());
    }

    @Override
    public String getIdentifier() {
        return "pzl";
    }
}
