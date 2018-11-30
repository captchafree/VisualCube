package Model.ImageGeneration.Generation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Handles loading and saving images
 */
class ImageHandler {

    /**
     * Returns the image located at the URL
     * @param url The URL to retrieve the image from
     * @return The image at the URL
     * @throws IOException If the image cannot be read
     */
    static BufferedImage getImage(URL url) {
        try {
            return ImageIO.read(url);
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Returns the image located at the URL
     * @param file The file to retrieve the image from
     * @return The image at the URL
     * @throws IOException If the image cannot be read
     */
    static BufferedImage getImage(File file) {
        try {
            return ImageIO.read(file);
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
    static boolean saveImageToFile(BufferedImage image, String filename) {
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

    /**
     * Saves an image to a specified file
     * @param image The image to save
     * @param file The file to save the image to
     * @return True if the image was saved successfully, false otherwise.
     */
    static boolean saveImageToFile(BufferedImage image, File file) {
        return saveImageToFile(image, file.toString());
    }
}
