package LAB1B.Bai1;

public class HinhVuong extends HCN {

	//Khởi tạo không tham số
	public HinhVuong() {
		super();
	}
	//Khởi tạo đầy đủ tham số
	public HinhVuong(double canh) {
		super(canh, canh);
	}
	//Getter & Setter
	public double getCanh() {
		return getDai();
	}
	public void setCanh(double canh) {
		setDai(canh);
		setRong(canh);
	}
	
	//Ghi đè phương thức xuất thông tin
	@Override
	public void xuatThongTin() {
		System.out.printf("Hình Vuông [Cạnh: %.2f | Chu vi: %.2f | Diện tích: %.2f]\n", 
                getCanh(), tinhChuVi(), tinhDienTich());
	}

}
