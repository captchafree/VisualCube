package Model.ImageGeneration.Testing;

import Model.ImageGeneration.Generation.VisualCube;
import Model.ImageGeneration.Preferences.BackgroundColor;
import Model.ImageGeneration.Preferences.StageMaskType;
import Model.ImageGeneration.Preferences.VCAttributes;

public class Examples {

    public static void main(String[] args) {
        VCAttributes preferences = new VCAttributes();
        VisualCube.saveImageWithPreferencesToFile(preferences, "examples/example_1");

        preferences = new VCAttributes.Builder()
                .backgroundColor(BackgroundColor.TRANSPARENT)
                .algorithm("S2 E2 M2")
                .imageSize(250)
                .build();

        VisualCube.saveImageWithPreferencesToFile(preferences, "examples/example_2");

        preferences = new VCAttributes.Builder()
                .backgroundColor(BackgroundColor.TRANSPARENT)
                .algorithmCase("R U R'")
                .stageMask(StageMaskType.F2L)
                .imageSize(250)
                .build();

        VisualCube.saveImageWithPreferencesToFile(preferences, "examples/example_3");
    }
}
