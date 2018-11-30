package Model.ImageGeneration.Generation;

import Model.ImageGeneration.Caching.ImageCache;

import java.awt.image.BufferedImage;

public class CubeImageGenerator {

    public static BufferedImage getImageWithPreferences(CubeImagePreferences preferences) {
        ImageCache cache = ImageCache.getInstance();
        return cache.get(preferences);
    }
}
