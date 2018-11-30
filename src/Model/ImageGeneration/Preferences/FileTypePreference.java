package Model.ImageGeneration.Preferences;

public class FileTypePreference extends Preference {

    public FileTypePreference(FileType fileType) {
        super(fileType.toString());
    }

    public FileTypePreference() {
        this(FileType.PNG);
    }

    @Override
    public String getIdentifier() {
        return "fmt";
    }
}
