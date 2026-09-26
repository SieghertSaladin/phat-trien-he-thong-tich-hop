package LAB3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
//1. bổ sung thêm StandardOpenOption
import java.nio.file.StandardOpenOption;

public class TextFileDemo {
	public static void main (String[] args) {
		Path file = Path.of("data", "ghi_chu.txt");
		//2. In đường dẫn tuyệt đối của tệp bằng file.toAbsolutePath(). 
		//Thêm dòng in đường dẫn tuyệt đối
		System.out.println("Đường dẫn tuyệt đối: " + file.toAbsolutePath());
		
		try {
			Files.createDirectories(file.getParent());
			
			//1. Sửa lại dòng khai báo writer:
			try (BufferedWriter writer = Files.newBufferedWriter(
					file, 
					StandardCharsets.UTF_8,
					StandardOpenOption.CREATE,
					StandardOpenOption.APPEND)) {
				writer.write("Java I/O làm việc với các luồng dữ liệu.");
				writer.newLine();
				writer.write("BufferedWriter giúp ghi văn bản hiệu quả.");
				writer.newLine();
				writer.write("UTF-8 hỗ trợ tiếng Việt ổn định.");
			}
			
			//3. Đổi StandardCharsets.UTF_8 thành StandardCharsets.US_ASCII khi đọc
			try (BufferedReader reader = Files.newBufferedReader(
					file, StandardCharsets.US_ASCII/**StandardCharsets.UTF_8**/)) {
				String line;
				int number = 1;
				while ((line = reader.readLine()) !=null) {
					System.out.printf("%d. $s$n", number++, line);
				}
			}
		} catch (IOException e) {
			System.out.println("Lỗi xử lý tệp " + file + ": " 
					+ e.getMessage());
		}
	}
}
//Nhận xét kết quả: Khi đọc tệp văn bản có chứa tiếng Việt (đã được ghi bằng UTF-8) 
//bằng một charset không hỗ trợ đầy đủ tiếng Việt (như US-ASCII), 
//các ký tự có dấu sẽ bị hiển thị sai, biến thành dấu hỏi chấm ? hoặc các ký tự rác. 
//Điều này xảy ra do sự không đồng nhất giữa bộ mã hóa (lúc ghi) và bộ giải mã (lúc đọc).