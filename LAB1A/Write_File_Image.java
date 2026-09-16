package LAB1;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.imageio.ImageIO;

public class Write_File_Image {

	public static void saveFile(File path, String tfile, byte[] bfile) {
		try {
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(bfile));
			ImageIO.write(img, tfile, path);
		} catch (IOException ex) {
			Logger.getLogger(Write_File_Image.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void main(String[] args) {
	    // 1. Khai báo file ảnh gốc và file ảnh đích
	    File fileGoc = new File("D:\\test.png"); // Thay bằng đường dẫn ảnh có sẵn trên máy bạn
	    File fileMoi = new File("D:\\test.png");

	    // 2. Gọi hàm đọc file ảnh thành byte[]
	    System.out.println("Đang đọc file ảnh...");
	    byte[] imageBytes = Read_File_Image.readfile(fileGoc);

	    // 3. Kiểm tra nếu đọc thành công thì ghi ra file mới
	    if (imageBytes != null && imageBytes.length > 0) {
	        System.out.println("Đọc thành công! Kích thước: " + imageBytes.length + " bytes.");
	        
	        // Ghi file mới với định dạng "png"
	        saveFile(fileMoi, "png", imageBytes);
	        
	        System.out.println("Đã ghi file thành công tại: " + fileMoi.getAbsolutePath());
	    } else {
	        System.err.println("Đọc file thất bại hoặc file không tồn tại!");
	    }
	}

}
