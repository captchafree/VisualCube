package Model.ImageGeneration.Preferences;

import java.io.Serializable;

public enum FileType implements Serializable {

    GIF("gif"),
    JPEG("jpg"),
    PNG("png");

    private final String extension;

    FileType(String ext) {
        extension = ext;
    }

    public String toString() {
        return this.extension;
    }
}
