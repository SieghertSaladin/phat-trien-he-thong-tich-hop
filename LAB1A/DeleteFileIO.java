package LAB1;

import java.io.File;

public class DeleteFileIO {
	
	// Phương thức 1: Xóa tập tin ( File)
	private void deleteFile(String source) {
		//new file
		File file = new File(source);
		//check file exist
		//neu ton tai
		if(file.exists()) {
			System.out.println("file ton tai");
			file.delete();
			System.out.println("Xoa file thanh cong");
		}
		else {
			System.out.println("file khong ton tai");
		}
	}
	//Phương thức 2: Xóa thư mục rỗng ( Folder )
	public boolean deleteEmptyFolder(String source)
		{
			File folder = new File(source);
			//kiem tra neu folder ton tai thi xoa
			if(folder.exists())
			{
				folder.delete();
				System.out.println("folder ton tai\n xoa folder thanh cong");
				return true;
			}
			else
			{
				System.out.println("folder khong ton tai");
			}
			return false;
		}
	
	// Phương thức 3: Delete thư mục chứa Files
	public boolean deleteListFileInfolder(String source) {
		File folder = new File(source);
		// Folder tồn tại
		if (folder.exists()) {
			//danh sách file
			File[] listFile = folder.listFiles();
			if (listFile.length !=0) {
				for (File f : listFile) {
					//File thì xóa
					if (f.isFile()) {
						f.delete();
					}
				}
			}
			folder.delete();
			System.out.println("Delete folder thành công!");
			return true;
		}
		else {
			System.out.println("Folder không tồn tại!");
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1> Test xóa File
		DeleteFileIO deleteFileIO = new DeleteFileIO();
		deleteFileIO.deleteFile("D:/HK_3/PhatTrienHeThongTichHop/demo.txt");
		//2> Test xóa thư mục
		deleteFileIO.deleteEmptyFolder("D:/HK_3/PhatTrienHeThongTichHop/TestFolder");
		//3> Test xóa thư mục có chứa File
		deleteFileIO.deleteListFileInfolder("D:/HK_3/PhatTrienHeThongTichHop/TestFolder/demo");
	}
	
}
