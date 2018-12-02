package Model.ImageGeneration.Testing;

import Model.ImageGeneration.Generation.CubeImageGenerator;
import Model.ImageGeneration.Preferences.CubeImagePreferences;
import Model.ImageGeneration.Preferences.BackgroundColor;
import Model.ImageGeneration.Preferences.FileType;
import Model.ImageGeneration.Preferences.StageMaskType;

//TODO: Add a way to generate all algorithms listed in a text file using some custom thread object
//TODO: Integrate with AlgDB
public class Main {

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        CubeImagePreferences pref = new CubeImagePreferences.Builder()
                .algorithmCase("RUR'U'")
                .fileType(FileType.PNG)
                .imageSize(250)
                .puzzleType(3)
                .backgroundColor(BackgroundColor.TRANSPARENT)
                .stageMask(null)
                .build();

        pref.algorithmCase("S2M2E2");

        System.out.println(pref.toString());

        CubeImageGenerator.getImageWithPreferences(pref);
    }
}