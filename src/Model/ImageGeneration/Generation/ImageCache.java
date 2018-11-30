package Model.ImageGeneration.Generation;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class ImageCache {

    private HashMap<CubeImagePreferences, BufferedImage> cache;

    private static ImageCache instance;

    //private static File cacheFile = new File("image_cache");

    private ImageCache() {
        this.reload();
    }

    public static ImageCache getInstance() {
        if(instance == null) {
            instance = new ImageCache();
        }
        return instance;
    }

    public void put(CubeImagePreferences pref, BufferedImage img) {
        this.cache.put(pref, img);
    }

    public BufferedImage get(CubeImagePreferences pref) {
        return this.cache.get(pref);
    }

    public void reload() {
        this.cache = new HashMap<>();
    }

    public void save() {

    }
}
