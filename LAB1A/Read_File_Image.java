package LAB1;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Read_File_Image {

	public static byte[] readfile(File path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			byte[] buf = new byte[1024];
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			for (int readNum; (readNum = fis.read(buf)) != -1;) {
				bos.write(buf, 0, readNum);
			}
			return bos.toByteArray();
		} catch (IOException ex) {
			Logger.getLogger(Read_File_Image.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
