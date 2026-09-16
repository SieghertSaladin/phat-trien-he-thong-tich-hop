package LAB1;

import java.util.Scanner;

public class Bai4 {
//Viết chương trình nhập vào một số, sau đó
// in ra màn hình số vừa nhập là số chẵn hay lẻ
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner scanner = new Scanner(System.in);
	System.out.println(">> Kiểm tra số chẳn lẽ<<");
	System.out.print("Vui lòng nhập số cần kiểm tra: ");
	int so = scanner.nextInt();
	if (so % 2 ==0) {
		System.out.println("Số "+ so + " là số chẵn.");
	}else {
		System.out.println("Số "+ so + " là số lẻ.");
	}
	}

}
