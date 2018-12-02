package ImageGeneration.Attributes;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.HashMap;

//TODO: Add more attributes
public class VCAttributes {

    private HashMap<Class, Attribute> attributes;

    @NotNull
    private FileTypeAttribute fileTypePreferred;

    public VCAttributes() {
        //Default file type is PNG
        this(FileType.PNG);
    }

    public VCAttributes(FileType fileType) {
        attributes = new HashMap<>();
        fileTypePreferred = new FileTypeAttribute(fileType);
    }

    @Override
    public String toString() {
        Attribute[] prefs = attributes.values().toArray(new Attribute[0]);
        Arrays.sort(prefs);

        String[] terms = new String[prefs.length + 1];

        for(int i = 0; i < prefs.length; i++) {
            terms[i] = prefs[i].toString();
        }
        terms[terms.length - 1] = fileTypePreferred.toString() + "." + fileTypePreferred.getValue();

        String result = String.join("&", terms);

        return result;
    }

    /**
     * Gets the file extension associated with the attributes.
     * @return the file extension (e.g. "png", "jpg", "gif")
     */
    public String getFileExtension() {
        return fileTypePreferred.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VCAttributes that = (VCAttributes) o;
        return that.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    //====================================Setters====================================

    public VCAttributes algorithm(String algorithm) {
        if(algorithm == null) {
            return this;
        }

        attributes.put(AlgorithmAttribute.class, new AlgorithmAttribute(algorithm));
        return this;
    }

    public VCAttributes fileType(FileType fileType) {
        if(fileType == null) {
            return this;
        }

        fileTypePreferred = new FileTypeAttribute(fileType);
        return this;
    }

    public VCAttributes imageSize(Integer size) {
        if(size == null) {
            return this;
        }

        attributes.put(SizeAttribute.class, new SizeAttribute(size));
        return this;
    }

    public VCAttributes backgroundColor(BackgroundColor color) {
        if(color == null) {
            return this;
        }

        attributes.put(BackgroundColorAttribute.class, new BackgroundColorAttribute(color));
        return this;
    }

    public VCAttributes puzzleType(Integer size) {
        if(size == null) {
            return this;
        }

        attributes.put(PuzzleTypeAttribute.class, new PuzzleTypeAttribute(size));
        return this;
    }

    public VCAttributes algorithmCase(String algorithm) {
        if(algorithm == null) {
            return this;
        }

        attributes.put(CaseAttribute.class, new CaseAttribute(algorithm));
        return this;
    }

    public VCAttributes stageMask(StageMaskType mask) {
        if(mask == null) {
            return this;
        }

        attributes.put(StageMaskType.class, new StageMaskAttribute(mask));
        return this;
    }

    public VCAttributes view(ViewType view) {
        if(view == null) {
            return this;
        }

        attributes.put(ViewAttribute.class, new ViewAttribute(view));
        return this;
    }
}
