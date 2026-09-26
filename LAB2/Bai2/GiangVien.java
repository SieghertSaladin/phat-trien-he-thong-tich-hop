package LAB2.Bai2;

public class GiangVien extends Nguoi {
    private String maGiangVien;
    private String chuyenMon;
    private double luongCoBan;
    private double heSoLuong;

    public GiangVien(String hoTen, int namSinh, String diaChi, String maGiangVien, String chuyenMon, double luongCoBan, double heSoLuong) {
        super(hoTen, namSinh, diaChi); // Gọi constructor của lớp cha
        this.maGiangVien = maGiangVien;
        this.chuyenMon = chuyenMon;
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
    }

    public double tinhLuong() {
        return luongCoBan * heSoLuong;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin(); // Tận dụng code hiển thị của lớp cha
        System.out.println(" | Mã GV: " + maGiangVien + " | Chuyên môn: " + chuyenMon + 
                           " | Lương: " + tinhLuong());
    }
}
