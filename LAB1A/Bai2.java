package LAB1;

import java.util.Scanner;

public class Bai2 {
//Viết chương trình nhập vào tên sau đó in 
//ra màn hình với tên vừa nhập
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("What's your name?");
		String str = scanner.nextLine();
		System.out.println("Hi, I am " + str);
	}

}
