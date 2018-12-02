package Model.ImageGeneration.Generation;

import Model.ImageGeneration.Preferences.VCAttributes;

import java.awt.image.BufferedImage;
import java.io.File;

public class VisualCube {

    private static ImageCache cache = ImageCache.getInstance();

    /**
     * Returns an image with the specified preferences.
     * @param preferences The preferences to be used to generate the image.
     * @return An image matching the specified preferences.
     */
    public static BufferedImage getImageWithAttributes(VCAttributes preferences) {
        return cache.get(preferences);
    }

    /**
     * Saves an image to a specified file.
     * @param preferences The set of preferences used to generate the image.
     * @param filename The name of the file to save the image to. Note that the file extension should be omitted
     *                 since it is contained in the preferences.
     */
    public static void saveImageWithAttributesToFile(VCAttributes preferences, String filename) {
        BufferedImage img = getImageWithAttributes(preferences);
        File file = new File(filename.substring(0, filename.lastIndexOf("/")));
        file.mkdirs();
        ImageHandler.saveImageToFile(img, filename + "." + preferences.getFileExtension());
    }

    /**
     * Sets the url that the generator will attempt to connect to. The url must be running an instance of VisualCube
     * in order for image generation to work. By default the url is VisualCube's author's website (http://cube.crider.co.uk/visualcube.php).
     * @param url The url to be used for image generation
     */
    public static void setURL(String url) {
        cache.setURL(url);
    }

    static void clearCache() {
        cache.clear();
    }
}
