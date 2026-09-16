package LAB1;

import java.util.Scanner;
class Animal {
String type;
String name;
double weight;
double meatPerDay;
double length;
String favoriteFood;
void showInfo() {
    if (type.equals("Sư tử")) {
        System.out.println("Sư tử " + name + " nặng " + weight + " cân và ăn " + meatPerDay + " cân thịt mỗi ngày.");
    } else if (type.equals("Rắn")) {
        System.out.println("Con rắn " + name + " nặng " + weight + " cân và dài " + length + " mét.");
    } else if (type.equals("Khỉ")) {
        System.out.println("Con khỉ " + name + " nặng " + weight + " cân và thích ăn " + favoriteFood + ".");
    }
}
}
public class Bai6 {
//Viết một chương trình quản lý động vật cho phép quản lý
//vật nuôi, người chủ cần biết mỗi ngày sư tử ăn bao nhiêu thức ăn
// độ dài của rắn và thức ăn yêu thích của khỉ
	public static void Bai6(String[] args) {
		Scanner sc = new Scanner(System.in);
		Animal animal = new Animal();
		System.out.println("=== CHỌN LOẠI ĐỘNG VẬT ===");
        System.out.println("1. Sư tử");
        System.out.println("2. Rắn");
        System.out.println("3. Khỉ");
        System.out.print("Mời bạn chọn (1-3): ");
        int choice = sc.nextInt();
        sc.nextLine(); // Xóa bộ nhớ đệm sau khi nhập số

        // Nhập thuộc tính chung
        System.out.print("Nhập tên: ");
        animal.name = sc.nextLine();
        System.out.print("Nhập cân nặng (cân): ");
        animal.weight = sc.nextDouble();
        sc.nextLine(); // Xóa bộ nhớ đệm

        // Sử dụng switch-case để xử lý thuộc tính riêng từng loài
        switch (choice) {
            case 1:
                animal.type = "Sư tử";
                System.out.print("Nhập số cân thịt ăn mỗi ngày: ");
                animal.meatPerDay = sc.nextDouble();
                break;
            case 2:
                animal.type = "Rắn";
                System.out.print("Nhập chiều dài (mét): ");
                animal.length = sc.nextDouble();
                break;
            case 3:
                animal.type = "Khỉ";
                System.out.print("Nhập thức ăn yêu thích: ");
                animal.favoriteFood = sc.nextLine();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        // Hiển thị thông tin vừa nhập
        System.out.println("\n--- THÔNG TIN VỪA NHẬP ---");
        animal.showInfo();

        sc.close();
    }
}
