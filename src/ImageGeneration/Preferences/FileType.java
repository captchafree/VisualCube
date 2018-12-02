package ImageGeneration.Preferences;

public enum FileType {

    GIF("gif"),
    JPEG("jpg"),
    PNG("png");

    private final String extension;

    FileType(String ext) {
        extension = ext;
    }

    @Override
    public String toString() {
        return this.extension;
    }
}
