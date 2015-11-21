package picView.picture.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtil {
    
    public static final int SAME = -1;
    public static final int RATIO = 0;
    
    public static void resize(File src) throws IOException {
        FileInputStream srcIs = null;
        try {
            srcIs = new FileInputStream(src);
           
        } finally {
            if (srcIs != null) try { srcIs.close(); } catch(IOException ex) {}
        }
    }

    
}







