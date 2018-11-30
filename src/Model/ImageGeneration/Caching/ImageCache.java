package Model.ImageGeneration.Caching;

import Model.ImageGeneration.Generation.CubeImagePreferences;
import Model.ImageGeneration.Generation.ImageHandler;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

//TODO: restrict the cache to a specified size / # of images
//TODO: make caching optional
//TODO: Implement LRU algorithm
public class ImageCache {

    private static ImageCache instance;

    //The directory to store the cached images
    private static String cacheDirectory = "image_cache/";

    private static final String url = "http://68.183.24.81/visualcube/visualcube.php?";

    private ImageCache() {}

    public static ImageCache getInstance() {
        if(instance == null) {
            instance = new ImageCache();
        }
        return instance;
    }

    public BufferedImage get(CubeImagePreferences pref) {
        File cachedImage = new File(cacheDirectory + pref.hashCode() + ".png");
        if(cachedImage.exists()) {
            return ImageHandler.getImage(cachedImage);
        }

        BufferedImage result = null;
        try {
            result = ImageHandler.getImage(new URL(url + pref.toString()));
            ImageHandler.saveImageToFile(result, cachedImage);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void clear() {
        for(File file : new File(cacheDirectory).listFiles()) {
            file.delete();
        }
    }
}
