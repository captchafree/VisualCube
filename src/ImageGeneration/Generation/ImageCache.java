package ImageGeneration.Generation;

import ImageGeneration.Attributes.VCAttributes;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

//TODO: restrict the cache to a specified size / # of images
//TODO: Implement LRU algorithm
//TODO: Add config file for fields

class ImageCache {

    private static ImageCache instance;

    //The directory to store the cached images
    private static final String cacheDirectory = "VisualCube/cache/";

    //The url of visual cube
    private static String url = "http://cube.crider.co.uk/visualcube.php?";

    private ImageCache() {
        File cache = new File(cacheDirectory);
        if(!cache.exists()) {
            cache.mkdirs();
        }
    }

    static ImageCache getInstance() {
        if(instance == null) {
            instance = new ImageCache();
        }
        return instance;
    }

    /**
     * Sets the url that the generator will attempt to connect to. The url must be running an instance of VisualCube
     * in order for image generation to work. By default the url is VisualCube's author's website (http://cube.crider.co.uk/visualcube.php).
     * @param url The url to be used for image generation
     */
    public void setURL(String url) {
        this.url = url + "?";
    }

    BufferedImage get(VCAttributes pref) {
        File cachedImage = new File(cacheDirectory + pref.hashCode() + "." + pref.getFileExtension());
        if(cachedImage.exists()) {
            return ImageHandler.getImage(cachedImage);
        }

        try {
            final BufferedImage result = ImageHandler.getImage(new URL(url + pref.toString()));

            new Thread(new Runnable() {
                @Override
                public void run() {
                    ImageHandler.saveImageToFile(result, cachedImage);
                }
            }).start();

            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    void clear() {
        for(File file : new File(cacheDirectory).listFiles()) {
            file.delete();
        }
    }
}
