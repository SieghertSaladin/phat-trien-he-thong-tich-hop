package LAB2.Bai2;

public class SinhVien extends Nguoi {
    private String maSinhVien;
    private String nganhHoc;
    private double diemTrungBinh;

    public SinhVien(String hoTen, int namSinh, String diaChi, String maSinhVien, String nganhHoc, double diemTrungBinh) {
        super(hoTen, namSinh, diaChi); // Gọi constructor của lớp cha
        this.maSinhVien = maSinhVien;
        this.nganhHoc = nganhHoc;
        this.diemTrungBinh = diemTrungBinh;
    }

    public String xepLoai() {
        if (diemTrungBinh >= 8.5) return "Giỏi";
        if (diemTrungBinh >= 7.0) return "Khá";
        if (diemTrungBinh >= 5.0) return "Trung bình";
        return "Yếu";
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin(); // Tận dụng code hiển thị của lớp cha
        System.out.println(" | Mã SV: " + maSinhVien + " | Ngành học: " + nganhHoc + 
                           " | ĐTB: " + diemTrungBinh + " | Xếp loại: " + xepLoai());
    }
}
