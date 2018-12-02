package ImageGeneration.Attributes;

import java.util.HashMap;

//TODO: Add more attributes
//TODO: Refactor to remove duplicate code
public class VCAttributes {

    public static class Builder {

        private HashMap<Class, Attribute> attributes;
        private FileTypeAttribute fileTypePreferred;

        public Builder() {
            attributes = new HashMap<>();

            //Default file type is PNG
            fileTypePreferred = new FileTypeAttribute(FileType.PNG);
        }

        public Builder algorithm(String algorithm) {
            if(algorithm == null) {
                return this;
            }

            attributes.put(AlgorithmAttribute.class, new AlgorithmAttribute(algorithm));
            return this;
        }

        public Builder fileType(FileType fileType) {
            if(fileType == null) {
                return this;
            }

            fileTypePreferred = new FileTypeAttribute(fileType);
            return this;
        }

        public Builder imageSize(Integer size) {
            if(size == null) {
                return this;
            }

            attributes.put(SizeAttribute.class, new SizeAttribute(size));
            return this;
        }

        public Builder backgroundColor(BackgroundColor color) {
            if(color == null) {
                return this;
            }

            attributes.put(BackgroundColorAttribute.class, new BackgroundColorAttribute(color));
            return this;
        }

        public Builder puzzleType(Integer size) {
            if(size == null) {
                return this;
            }

            attributes.put(PuzzleTypeAttribute.class, new PuzzleTypeAttribute(size));
            return this;
        }

        public Builder algorithmCase(String algorithm) {
            if(algorithm == null) {
                return this;
            }

            attributes.put(CaseAttribute.class, new CaseAttribute(algorithm));
            return this;
        }

        public Builder stageMask(StageMaskType mask) {
            if(mask == null) {
                return this;
            }

            attributes.put(StageMaskType.class, new StageMaskAttribute(mask));
            return this;
        }

        public Builder view(ViewType view) {
            if(view == null) {
                return this;
            }

            attributes.put(ViewAttribute.class, new ViewAttribute(view));
            return this;
        }

        public VCAttributes build() {
            VCAttributes pref = new VCAttributes();
            pref.attributes = this.attributes;
            pref.fileTypePreferred = this.fileTypePreferred;
            return pref;
        }
    }

    private HashMap<Class, Attribute> attributes;
    private FileTypeAttribute fileTypePreferred;

    public VCAttributes() {
        attributes = new HashMap<>();

        //Default file type is PNG
        fileTypePreferred = new FileTypeAttribute(FileType.PNG);
    }

    @Override
    public String toString() {
        Attribute[] prefs = attributes.values().toArray(new Attribute[0]);
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

    public void algorithm(String algorithm) {
        if(algorithm == null) {
            return;
        }

        attributes.put(AlgorithmAttribute.class, new AlgorithmAttribute(algorithm));
        return;
    }

    public void fileType(FileType fileType) {
        if(fileType == null) {
            return;
        }

        fileTypePreferred = new FileTypeAttribute(fileType);
        return;
    }

    public void imageSize(Integer size) {
        if(size == null) {
            return;
        }


        attributes.put(SizeAttribute.class, new SizeAttribute(size));
        return;
    }

    public void backgroundColor(BackgroundColor color) {
        if(color == null) {
            return;
        }

        attributes.put(BackgroundColorAttribute.class, new BackgroundColorAttribute(color));
        return;
    }

    public void puzzleType(Integer size) {
        if(size == null) {
            return;
        }

        attributes.put(PuzzleTypeAttribute.class, new PuzzleTypeAttribute(size));
        return;
    }

    public void algorithmCase(String algorithm) {
        if(algorithm == null) {
            return;
        }

        attributes.put(CaseAttribute.class, new CaseAttribute(algorithm));
        return;
    }

    public void stageMask(StageMaskType mask) {
        if(mask == null) {
            return;
        }

        attributes.put(StageMaskType.class, new StageMaskAttribute(mask));
        return;
    }

    public void view(ViewType view) {
        if(view == null) {
            return;
        }

        attributes.put(ViewAttribute.class, new ViewAttribute(view));
        return;
    }
}
