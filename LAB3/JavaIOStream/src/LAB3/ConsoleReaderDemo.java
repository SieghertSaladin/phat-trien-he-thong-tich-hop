package LAB3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ConsoleReaderDemo {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in, StandardCharsets.UTF_8));
		
		int count = 0;
		System.out.println("Nhập văn bản; nhập q để kết thúc:");
		
		try {
			while (true) {
				String line = reader.readLine();
				
				if(line == null || line.equalsIgnoreCase("q")) {
					break;
				}
				
				count ++;
				System.out.printf("Dòng %d: %s%n", count, line);
			}
		} catch (IOException e) {
			System.out.println("Không thể đọc dữ liệu: " + e.getMessage());
		}
		System.out.println("Tổng số dòng đã nhập: " + count);
	}
}

/**1) Vì sao cần InputStreamReader giữa System.in và BufferedReader?
 * Bản thân System.in là luồng dữ liệu đầu vào dạng byte.  
 * Cần sử dụng InputStreamReader để làm nhiệm vụ giải mã (ví dụ: giải mã UTF-8) và chuyển đổi luồng byte này thành luồng ký tự.  
 * Sau quá trình chuyển đổi đó, BufferedReader mới có thể tiếp nhận để đọc văn bản một cách hiệu quả và hỗ trợ phương thức readLine().
 *   
 * 2) readLine() trả về giá trị nào khi gặp EOF?
 * Phương thức readLine() sẽ trả về giá trị null khi gặp điểm kết thúc luồng (EOF).  
 * Trong đoạn mã tham khảo của bài thực hành, vòng lặp đọc dữ liệu sử dụng điều kiện if (line == null ...) 
 * để dùng lệnh break thoát khỏi vòng lặp.
 *   
 * 3) Vì sao ví dụ không đóng reader gắn với System.in?
 * Ví dụ không đóng reader vì theo các nguyên tắc quan trọng khi làm việc với I/O Stream, 
 * bạn không được đóng System.in hoặc System.out nếu chương trình vẫn còn cần sử dụng các luồng hệ thống này.   **/
