package LAB2.Bai1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Tạo và nhập thông tin từ bàn phím cho 2 sản phẩm
        System.out.println("--- NHẬP THÔNG TIN SẢN PHẨM 1 ---");
        System.out.print("Nhập mã SP: ");
        String ma1 = sc.nextLine();
        System.out.print("Nhập tên SP: ");
        String ten1 = sc.nextLine();
        System.out.print("Nhập đơn giá: ");
        double gia1 = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng tồn kho: ");
        int sl1 = Integer.parseInt(sc.nextLine());
        SanPham sp1 = new SanPham(ma1, ten1, gia1, sl1);

        System.out.println("\n--- NHẬP THÔNG TIN SẢN PHẨM 2 ---");
        System.out.print("Nhập mã SP: ");
        String ma2 = sc.nextLine();
        System.out.print("Nhập tên SP: ");
        String ten2 = sc.nextLine();
        System.out.print("Nhập đơn giá: ");
        double gia2 = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng tồn kho: ");
        int sl2 = Integer.parseInt(sc.nextLine());
        SanPham sp2 = new SanPham(ma2, ten2, gia2, sl2);

        // Hiển thị thông tin ban đầu
        System.out.println("\n--- TRẠNG THÁI BAN ĐẦU ---");
        sp1.hienThiThongTin();
        sp2.hienThiThongTin();

        // 2. Nhập thêm hàng cho Sản phẩm 1
        System.out.println("\n--- NHẬP THÊM HÀNG ---");
        System.out.print("Nhập số lượng muốn thêm cho SP1: ");
        int soLuongNhap = Integer.parseInt(sc.nextLine());
        sp1.nhapHang(soLuongNhap);
        System.out.println("-> Thông tin SP1 sau khi nhập thêm hàng:");
        sp1.hienThiThongTin();

        // 3. Thử bán hàng thành công (Bán một lượng nhỏ hơn tồn kho hiện có của SP2)
        System.out.println("\n--- BÁN HÀNG THÀNH CÔNG ---");
        System.out.print("Nhập số lượng muốn bán của SP2 (nhập số nhỏ hơn " + sl2 + "): ");
        int slBanThanhCong = Integer.parseInt(sc.nextLine());
        boolean ketQua1 = sp2.banHang(slBanThanhCong);
        System.out.println("Kết quả giao dịch: " + (ketQua1 ? "Thành công" : "Thất bại"));
        System.out.println("-> Thông tin SP2 sau khi bán:");
        sp2.hienThiThongTin();

        // 4. Thử bán hàng với số lượng lớn hơn tồn kho của SP2
        System.out.println("\n--- BÁN HÀNG THẤT BẠI (QUÁ TỒN KHO) ---");
        System.out.print("Nhập số lượng muốn bán của SP2 (nhập số rất lớn, ví dụ 1000): ");
        int slBanThatBai = Integer.parseInt(sc.nextLine());
        boolean ketQua2 = sp2.banHang(slBanThatBai);
        System.out.println("Kết quả giao dịch: " + (ketQua2 ? "Thành công" : "Thất bại"));
        System.out.println("-> Thông tin SP2 sau khi thử bán:");
        sp2.hienThiThongTin();
        
        sc.close();
    }
}
