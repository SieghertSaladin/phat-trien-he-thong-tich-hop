package LAB1;

import java.io.File;
import java.io.IOException;

public class DeleteDirTH3 {

	public boolean deleteListFileInfolder(String source) throws IOException {
		File folder = new File(source);
		//folder tồn tại
		if (folder.exists()) {
			//danh sách file
			File[] listFile = folder.listFiles();
			if (listFile.length != 0) {
				for (File f : listFile) {
					// nếu là file thì delete
					if(f.isFile()) {
						f.delete();
					}
					// nếu là thư mục thì gọi đề quy lại
					if(f.isDirectory()) {
						deleteListFileInfolder(f.getAbsolutePath());
					}
				}
			}
			folder.delete();
			System.out.println("Delete folder thành công!");
			return true;
		} else {
			System.out.println("Folder không tồn tại");
			return false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		DeleteDirTH3 deleteDirTH3 = new DeleteDirTH3();
		
		deleteDirTH3.deleteListFileInfolder("D:\\HK_3\\PhatTrienHeThongTichHop\\TestFolder");
		// TODO Auto-generated method stub

	}

}
