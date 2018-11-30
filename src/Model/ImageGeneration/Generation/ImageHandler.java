package Model.ImageGeneration.Generation;

import Model.ImageGeneration.Caching.ImageSaveCompletionListener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Handles loading and saving images
 */
public class ImageHandler {

    /**
     * Returns the image located at the URL
     * @param url The URL to retrieve the image from
     * @return The image at the URL
     * @throws IOException If the image cannot be read
     */
    public static BufferedImage getImage(URL url) {
        try {
            return ImageIO.read(url);
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Returns the image located at the URL
     * @param filename The file to retrieve the image from
     * @return The image at the URL
     * @throws IOException If the image cannot be read
     */
    public static BufferedImage getImage(String filename) {
        try {
            return ImageIO.read(new File(filename));
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
            return true;
        }

        String formatType = filename.substring(filename.indexOf(".") + 1);

        try {
            BufferedImage imageToSave = image;
            File file = new File(filename);
            ImageIO.write(imageToSave, formatType, file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void saveImageToFile(BufferedImage image, String filename, ImageSaveCompletionListener listener) {
        if(image == null) {
            listener.onFailure();
            return;
        }

        String formatType = filename.substring(filename.indexOf(".") + 1);

        try {
            BufferedImage imageToSave = image;
            File file = new File(filename);
            ImageIO.write(imageToSave, formatType, file);
            listener.onSuccess();
        } catch (IOException e) {
            e.printStackTrace();
            listener.onFailure();
        }
    }
}
