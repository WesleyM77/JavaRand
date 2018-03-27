package javarndv1;
import com.github.sarxos.webcam.Webcam;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Formatter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Wesley
 */
public class mainController {
    private mainUI theMainUI;
    private Webcam webcam;
    private String hash;
    private byte[] hashBytes;
    private SecureRandom gen;
    
    public mainController() throws IOException
    {
        webcam = Webcam.getDefault();
        if (webcam != null) 
        {
            JOptionPane.showMessageDialog(null, "Webcam: " + webcam.getName() + "\nAfter pressing \"Ok,\" please wait a few seconds.");
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "No webcam detected. Exiting.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        theMainUI = new mainUI(this);
        theMainUI.setVisible(true);
        theMainUI.setLocationRelativeTo(null);
        
    }
    
    public ImageIcon requestImage() throws IOException
    {
        // get the current image to show source of randomness
        // change folder so you can save images
        if (!webcam.isOpen())
            webcam.open();

        // get image
        BufferedImage image = webcam.getImage();

        // save image to PNG file
        ImageIO.write(image, "JPG", new File("noise.jpg"));
        return new ImageIcon("noise.jpg");
    }
    
    public void updateHash(String newHash)
    {
        hash = newHash;        
        hashBytes = hexStringToByteArray(hash);
        gen = new SecureRandom(hashBytes);
    }
    
    public int generateNewNumber(int min, int max)
    {
        return gen.nextInt(max-min+1)+min;
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
    
}
