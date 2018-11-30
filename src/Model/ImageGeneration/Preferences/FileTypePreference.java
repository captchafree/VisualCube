package Model.ImageGeneration.Preferences;

class FileTypePreference extends Preference {

    FileTypePreference(FileType fileType) {
        super(fileType.toString());
    }

    FileTypePreference() {
        this(FileType.PNG);
    }

    @Override
    String getIdentifier() {
        return "fmt";
    }
}
