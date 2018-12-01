package Model.ImageGeneration.Generation;

import Model.ImageGeneration.Preferences.CubeImagePreferences;

import java.awt.image.BufferedImage;

public class CubeImageGenerator {

    private static ImageCache cache = ImageCache.getInstance();

    public static BufferedImage getImageWithPreferences(CubeImagePreferences preferences) {
        return cache.get(preferences);
    }

    static void clearCache() {
        cache.clear();
    }
}
