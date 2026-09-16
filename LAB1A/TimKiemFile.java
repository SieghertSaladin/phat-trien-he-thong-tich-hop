package LAB1;

import java.io.File;

public class TimKiemFile {

	public void findFile(String source, String key) {
		File file = new File(source);
		if(file.exists()) {
			if(file.isFile()) {
				if(file.getName().endsWith(key)) {
					System.out.println(file.getAbsolutePath());
				}
			}
			File[] listFile = file.listFiles();
			if(listFile != null) {
				for(File f:listFile) {
					findFile(f.getAbsolutePath(),key);
				}
			}
		} else {
			System.out.println("Source không tồn tại");
		}
	}
	public static void main(String[] args) {
		TimKiemFile searcher = new TimKiemFile();
		// TODO Auto-generated method stub
		//thay đường dẫn và từ khóa cần tìm (ví dụ tìm file.txt)
		searcher.findFile("D:\\HK_3", ".txt");

	}

}
