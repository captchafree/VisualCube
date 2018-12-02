package ImageGeneration.Attributes;

class FileTypeAttribute extends Attribute {

    FileTypeAttribute(FileType fileType) {
        super(fileType);
    }

    FileTypeAttribute() {
        this(FileType.PNG);
    }

    @Override
    String getIdentifier() {
        return "fmt";
    }

    @Override
    protected String validateInput(Object input) {
        FileType fileType = (FileType) input;
        return input.toString();
    }
}
