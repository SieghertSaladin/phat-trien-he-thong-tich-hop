package LAB1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	
	public boolean copyFile(String source, String dest) throws FileNotFoundException, IOException {
		//file nguồn
		File sourceFile = new File(source);
		// file đích
		File destFile = new File(dest);
		// kiểm tra file nguồn có tồn tại ko
		if(sourceFile.exists()) {
			//luồng đọc file
			FileInputStream fis = new FileInputStream(sourceFile);
			// luồng ghi file
			FileOutputStream fos = new FileOutputStream(destFile);
			byte[] arr = new byte[1024];
			while ((fis.read(arr)) != -1) {
				fos.write(arr);
				fos.flush();
			}
			fis.close();
			fos.close();
			System.out.println("Copy thành công");
			return true; 
		} else {
			System.out.println("file nguồn ko tồn tại");
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyFile copier = new CopyFile();
		try {
			// thay đổi đường dẫn file nguồn và file đích thực tế của bạn
			copier.copyFile("D:\\HK_3\\a.txt", "D:\\HK_3\\b.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
