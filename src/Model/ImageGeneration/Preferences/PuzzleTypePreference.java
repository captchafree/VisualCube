package Model.ImageGeneration.Preferences;

class PuzzleTypePreference extends Preference {

    PuzzleTypePreference(Integer size) {
        super(size.toString());
    }

    @Override
    String getIdentifier() {
        return "pzl";
    }
}
