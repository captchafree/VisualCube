package ImageGeneration.Generation;

import ImageGeneration.Attributes.VCAttributes;

import java.awt.image.BufferedImage;
import java.io.File;

public class VisualCube {

    private static ImageCache cache = ImageCache.getInstance();

    /**
     * Returns an image with the specified attributes.
     * @param attributes The attributes to be used to generate the image.
     * @return An image matching the specified attributes.
     */
    public static BufferedImage getImageWithAttributes(VCAttributes attributes) {
        return cache.get(attributes);
    }

    /**
     * Saves an image to a specified file.
     * @param attributes The set of attributes used to generate the image.
     * @param filename The name of the file to save the image to. Note that the file extension should be omitted
     *                 since it is contained in the attributes.
     */
    public static void saveImageWithAttributesToFile(VCAttributes attributes, String filename) {
        BufferedImage img = getImageWithAttributes(attributes);
        File file = new File(filename.substring(0, filename.lastIndexOf("/")));
        file.mkdirs();
        ImageHandler.saveImageToFile(img, filename + "." + attributes.getFileExtension());
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
