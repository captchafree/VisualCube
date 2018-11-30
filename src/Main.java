import Model.ImageGeneration.Generation.CubeImageGenerator;
import Model.ImageGeneration.Generation.CubeImagePreferences;
import Model.ImageGeneration.Generation.ImageCache;
import Model.ImageGeneration.Generation.PrefBuilder;
import Model.ImageGeneration.Preferences.BackgroundColor;
import Model.ImageGeneration.Preferences.FileType;
import Model.ImageGeneration.Preferences.StageMaskType;


import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {

        CubeImagePreferences pref = new PrefBuilder()
                .algorithmCase("RUR'U'")
                .fileType(FileType.PNG)
                .imageSize(250)
                .puzzleType(3)
                .backgroundColor(BackgroundColor.PINK)
                .stageMask(StageMaskType.F2L)
                .build();

        System.out.println(pref.toString());

        //CubeImageGenerator.saveImageToFile(img, "cube.png");

        ImageCache cache = ImageCache.getInstance();

        long start, end;

        start = System.currentTimeMillis();
        BufferedImage img = CubeImageGenerator.getImageWithPreferences(pref);
        end = System.currentTimeMillis();

        System.out.println(end - start);

        cache.put(pref, img);

        start = System.currentTimeMillis();
        BufferedImage img1 = CubeImageGenerator.getImageWithPreferences(pref);
        end = System.currentTimeMillis();

        System.out.println(end - start);

        cache.save();
    }
}