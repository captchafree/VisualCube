package Model.ImageGeneration.Caching;

import Model.ImageGeneration.Generation.CubeImagePreferences;
import Model.ImageGeneration.Generation.ImageHandler;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;

//TODO: restrict the cache to a specified size / # of images
//TODO: make caching optional
public class ImageCache {

    //Stores pref, filename as cache
    private HashMap<CubeImagePreferences, String> cache;

    private static ImageCache instance;

    //The directory to store the cached images
    private static String cacheDirectory = "image_cache/";

    private ImageCache() {
        this.reload();
    }

    public static ImageCache getInstance() {
        if(instance == null) {
            instance = new ImageCache();
        }
        return instance;
    }

    public void put(CubeImagePreferences pref, BufferedImage image) {
        String filename = cacheDirectory + pref.hashCode() + ".png";
        ImageHandler.saveImageToFile(image, filename, new ImageSaveCompletionListener() {
            @Override
            public void onSuccess() {
                cache.put(pref, filename);
            }

            @Override
            public void onFailure() {}
        });
    }

    public String get(CubeImagePreferences pref) {
        return cache.get(pref);
    }

    private void reload() {
        try {
            FileInputStream fileIn = new FileInputStream(cacheDirectory + "cache_map");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            cache = (HashMap<CubeImagePreferences, String>) objectIn.readObject();
            objectIn.close();
            System.out.println("Cache Loaded...");
        } catch (FileNotFoundException e) {
            //Create cache
            cache = new HashMap<>();
            System.out.println("Cache initialized...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            FileOutputStream fileOut = new FileOutputStream(cacheDirectory + "cache_map");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(cache);
            objectOut.close();
            System.out.println("Cache Saved...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
