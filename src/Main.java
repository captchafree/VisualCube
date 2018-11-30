import Model.ImageGeneration.Caching.ImageCache;
import Model.ImageGeneration.Generation.CubeImageGenerator;
import Model.ImageGeneration.Generation.CubeImagePreferences;
import Model.ImageGeneration.Preferences.BackgroundColor;
import Model.ImageGeneration.Preferences.FileType;
import Model.ImageGeneration.Preferences.StageMaskType;
import SetupThreads.Initializer;

import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {
        Initializer.init();

        CubeImagePreferences pref = new CubeImagePreferences.Builder()
                .algorithmCase("RUR'U'")
                .fileType(FileType.PNG)
                .imageSize(500)
                .puzzleType(3)
                .backgroundColor(BackgroundColor.TRANSPARENT)
                .stageMask(StageMaskType.F2L)
                .build();

        System.out.println(pref.toString());


        long start, end;

        start = System.currentTimeMillis();
        BufferedImage img = CubeImageGenerator.getImageWithPreferences(pref);
        end = System.currentTimeMillis();

        System.out.println(end - start);


        start = System.currentTimeMillis();
        BufferedImage img1 = CubeImageGenerator.getImageWithPreferences(pref);
        end = System.currentTimeMillis();

        System.out.println(end - start);

    }
}