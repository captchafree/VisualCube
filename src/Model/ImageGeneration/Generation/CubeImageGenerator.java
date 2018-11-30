package Model.ImageGeneration.Generation;

import Model.ImageGeneration.Caching.ImageCache;

import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

public class CubeImageGenerator {

    private static final String url = "http://68.183.24.81/visualcube/visualcube.php?";

    public static BufferedImage getImageWithPreferences(CubeImagePreferences preferences) {

        ImageCache cache = ImageCache.getInstance();

        String filename = cache.get(preferences);

        if(filename != null) {
            return ImageHandler.getImage(filename);
        }

        try {
            BufferedImage result = ImageHandler.getImage(new URL(url + preferences.toString()));
            cache.put(preferences, result);
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
