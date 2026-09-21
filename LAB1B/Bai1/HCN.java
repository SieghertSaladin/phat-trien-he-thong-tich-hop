package LAB1B.Bai1;

public class HCN {

	private double dai;
	private double rong;
	
	//Khởi tạo không tham số
	public HCN() {
		this.dai = 0;
		this.rong = 0;
	}
	//Khởi tạo đầy đủ tham số
	public HCN(double dai, double rong) {
		this.dai = dai;
		this.rong = rong;
	}
	//Getter $ Setter
	public double getDai() {
		return dai;
	}
	public void setDai(double dai) {
		this.dai = dai;
	}
	public double getRong() {
		return rong;
	}
	public void setRong(double rong) {
		this.rong = rong;
	}
	//Tính chu vi
	public double tinhChuVi() {
		return (dai + rong)*2;
	}
	// Tính diện tích
	public double tinhDienTich() {
		return dai * rong;
	}
	// Xuất thông tin
	public void xuatThongTin() {
		System.out.printf("HCN [Dài: %.2f, Rộng: %.2f | Chu vi: %.2f | Diện tích: %.2f]\n", dai, rong, tinhChuVi(), tinhDienTich());
	}
	
}
