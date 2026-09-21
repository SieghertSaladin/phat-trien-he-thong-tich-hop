package LAB1B.Bai2;

import java.util.Scanner;

public class DemoArray {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Khởi tạo mảng có sức chứa tối đa 100 phần tử[cite: 1]
        IntArray myArray = new IntArray(100);

        // 1. Nhập và xuất mảng ban đầu[cite: 1]
        System.out.println("=== 1. NHẬP VÀ XUẤT MẢNG ===");
        myArray.nhapMang(sc);
        myArray.xuatMang();

        // 2. Thêm phần tử Y vào đầu, giữa (vị trí i) và cuối[cite: 1]
        System.out.println("\n=== 2. THÊM PHẦN TỬ ===");
        System.out.print("Nhập giá trị Y để thêm vào đầu: ");
        int yDau = sc.nextInt();
        myArray.themDau(yDau);
        myArray.xuatMang();

        System.out.print("Nhập giá trị Y để thêm vào cuối: ");
        int yCuoi = sc.nextInt();
        myArray.themCuoi(yCuoi);
        myArray.xuatMang();

        System.out.print("Nhập vị trí i cần thêm: ");
        int pos = sc.nextInt();
        System.out.print("Nhập giá trị Y để thêm tại vị trí " + pos + ": ");
        int yGiua = sc.nextInt();
        myArray.themVaoViTri(pos, yGiua);
        myArray.xuatMang();

        // 3. Tìm kiếm chưa sắp xếp[cite: 1]
        System.out.println("\n=== 3. TÌM KIẾM TRÊN MẢNG CHƯA SẮP XẾP ===");
        System.out.print("Nhập giá trị B cần tìm: ");
        int b1 = sc.nextInt();
        int idx1 = myArray.timKiemChuaSapXep(b1);
        if (idx1 != -1) {
            System.out.println("Tìm thấy " + b1 + " tại vị trí (chỉ số): " + idx1);
        } else {
            System.out.println("Không tìm thấy " + b1);
        }

        // 4. Sắp xếp mảng Radix Sort[cite: 1]
        System.out.println("\n=== 4. SẮP XẾP RADIX SORT ===");
        System.out.println("Đang sắp xếp tăng dần...");
        myArray.sapXepRadix(true);
        myArray.xuatMang();

        // 5. Tìm kiếm trên mảng đã sắp xếp (Nhị phân)[cite: 1]
        System.out.println("\n=== 5. TÌM KIẾM TRÊN MẢNG ĐÃ SẮP XẾP ===");
        System.out.print("Nhập giá trị B cần tìm nhị phân: ");
        int b2 = sc.nextInt();
        int idx2 = myArray.timKiemDaSapXep(b2);
        if (idx2 != -1) {
            System.out.println("Tìm thấy " + b2 + " tại vị trí: " + idx2);
        } else {
            System.out.println("Không tìm thấy " + b2);
        }

        // 6. Xóa phần tử[cite: 1]
        System.out.println("\n=== 6. XÓA PHẦN TỬ ===");
        System.out.print("Nhập chỉ số j cần xóa: ");
        int j = sc.nextInt();
        myArray.xoaTaiViTri(j);
        myArray.xuatMang();

        System.out.print("Nhập giá trị X cần xóa khỏi mảng: ");
        int x = sc.nextInt();
        myArray.xoaGiaTriX(x);
        myArray.xuatMang();

        sc.close();
    }
}
