package LAB2.Bai2;

import java.time.Year;

public class Nguoi {
    private String hoTen;
    private int namSinh;
    private String diaChi;

    public Nguoi(String hoTen, int namSinh, String diaChi) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
    }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public int getNamSinh() { return namSinh; }
    public void setNamSinh(int namSinh) { this.namSinh = namSinh; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public int tinhTuoi() {
        return Year.now().getValue() - this.namSinh;
    }

    public void hienThiThongTin() {
        System.out.print("Họ tên: " + hoTen + " | Năm sinh: " + namSinh + 
                         " | Tuổi: " + tinhTuoi() + " | Địa chỉ: " + diaChi);
    }
}
