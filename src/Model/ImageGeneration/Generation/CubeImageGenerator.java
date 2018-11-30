package Model.ImageGeneration.Generation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class CubeImageGenerator {

    private static final String url = "http://68.183.24.81/visualcube/visualcube.php?";

    private static ImageCache cache = ImageCache.getInstance();

    public static BufferedImage getImageWithPreferences(CubeImagePreferences preferences) {

        BufferedImage result = cache.get(preferences);

        if(result != null) {
            return result;
        }

        try {
            return getImage(new URL(url + preferences.toString()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns the image located at the URL
     * @param url The URL to retrieve the image from
     * @return The image at the URL
     * @throws IOException If the image cannot be read
     */
    private static BufferedImage getImage(URL url) {
        try {
            return ImageIO.read(url);
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Saves an image to a specified file
     * @param image The image to save
     * @param filename The name of the file to save the image to
     * @return True if the image was saved successfully, false otherwise.
     */
    public static boolean saveImageToFile(BufferedImage image, String filename) {
        if(image == null) {
            return false;
        }

        String formatType = filename.substring(filename.indexOf(".") + 1);

        try {
            BufferedImage imageToSave = image;
            File file = new File(filename);
            ImageIO.write(imageToSave, formatType, file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
