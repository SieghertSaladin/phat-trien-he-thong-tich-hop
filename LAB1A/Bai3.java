package LAB1;

import java.util.Scanner;

public class Bai3 {
//Viết chương trình nhập vào 2 số A và B
//sau đó in ra kết quả tính tổng
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Vui lòng nhập số thứ nhất: ");
		int soA = scanner.nextInt();
		System.out.print("Vui lòng nhập số thứ hai: ");
		int soB = scanner.nextInt();
		int kq = soA + soB;
		System.out.println("Tính tổng " + soA + " + " + soB + " = " + kq);
	}

}
