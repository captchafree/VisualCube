package ImageGeneration.Preferences;

class FileTypeAttribute extends Attribute {

    FileTypeAttribute(FileType fileType) {
        super(fileType.toString());
    }

    FileTypeAttribute() {
        this(FileType.PNG);
    }

    @Override
    String getIdentifier() {
        return "fmt";
    }
}
