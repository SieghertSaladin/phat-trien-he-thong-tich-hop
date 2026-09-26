package LAB2.Bai2;

public class Main {
    public static void main(String[] args) {
        // 1. Tạo hai sinh viên
        SinhVien sv1 = new SinhVien("Nguyễn Văn A", 2005, "Hà Nội", "SV01", "CNTT", 8.6);
        SinhVien sv2 = new SinhVien("Trần Thị B", 2006, "Hải Phòng", "SV02", "Kinh tế", 6.5);
        
        // 2. Tạo hai giảng viên
        GiangVien gv1 = new GiangVien("Lê Đình C", 1980, "Đà Nẵng", "GV01", "Toán rời rạc", 15000000, 2.5);
        GiangVien gv2 = new GiangVien("Phạm Thu D", 1985, "TP.HCM", "GV02", "Lập trình Java", 15000000, 3.0);

        // 3. Hiển thị thông tin từng đối tượng
        System.out.println("--- THÔNG TIN CHUNG TỪNG ĐỐI TƯỢNG ---");
        sv1.hienThiThongTin();
        sv2.hienThiThongTin();
        gv1.hienThiThongTin();
        gv2.hienThiThongTin();

        // 4. Hiển thị xếp loại sinh viên
        System.out.println("\n--- KẾT QUẢ XẾP LOẠI SINH VIÊN ---");
        System.out.println("Sinh viên: " + sv1.getHoTen() + " | Xếp loại: " + sv1.xepLoai());
        System.out.println("Sinh viên: " + sv2.getHoTen() + " | Xếp loại: " + sv2.xepLoai());

        // 5. Hiển thị lương giảng viên
        System.out.println("\n--- BẢNG LƯƠNG GIẢNG VIÊN ---");
        System.out.println("Giảng viên: " + gv1.getHoTen() + " | Tổng lương: " + gv1.tinhLuong());
        System.out.println("Giảng viên: " + gv2.getHoTen() + " | Tổng lương: " + gv2.tinhLuong());
    }
}