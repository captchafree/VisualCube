package Model.ImageGeneration.Testing;

import Model.ImageGeneration.Generation.VisualCube;
import Model.ImageGeneration.Preferences.VCAttributes;
import Model.ImageGeneration.Preferences.BackgroundColor;
import Model.ImageGeneration.Preferences.FileType;

//TODO: Add a way to generate all algorithms listed in a text file using some custom thread object
//TODO: Integrate with AlgDB
public class Main {

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        VCAttributes pref = new VCAttributes.Builder()
                .algorithmCase("R U R' U'")
                .fileType(FileType.PNG)
                .imageSize(250)
                .puzzleType(3)
                .backgroundColor(BackgroundColor.TRANSPARENT)
                .stageMask(null)
                .build();

        //pref.algorithmCase("S2M2E2");

        System.out.println(pref.toString());

        VisualCube.getImageWithPreferences(pref);
    }
}