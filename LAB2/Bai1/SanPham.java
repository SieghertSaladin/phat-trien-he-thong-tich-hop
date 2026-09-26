package LAB2.Bai1;

public class SanPham {
    private String maSP;
    private String tenSP;
    private double donGia;
    private int soLuong;

    public SanPham(String maSP, String tenSP, double donGia, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public double tinhThanhTien() {
        return donGia * soLuong;
    }

    public void nhapHang(int soLuongNhap) {
        if (soLuongNhap > 0) {
            soLuong += soLuongNhap;
        } else {
            System.out.println("Số lượng nhập phải lớn hơn 0.");
        }
    }

    public boolean banHang(int soLuongBan) {
        if (soLuongBan > 0 && soLuongBan <= soLuong) {
            soLuong -= soLuongBan;
            return true;
        }
        return false;
    }

    public void hienThiThongTin() {
        System.out.println("Mã SP: " + maSP + " | Tên SP: " + tenSP +
                " | Đơn giá: " + donGia + " | Tồn kho: " + soLuong +
                " | Thành tiền: " + tinhThanhTien());
    }
}
