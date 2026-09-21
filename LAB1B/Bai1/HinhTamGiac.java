package LAB1B.Bai1;

public class HinhTamGiac {
	private double a, b, c;
	
	// Khởi tạo không tham số
	public HinhTamGiac() {
		this.a = 0;
		this.b = 0;
		this.c = 0;
	}
	
	// khởi tạo đầy đủ tham số
	public HinhTamGiac(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	//Getter & Setter

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}
	//Tính chu vi
	public double tinhChuVi() {
		return a + b + c;
	}
	// Tính diện tích
	public double tinhDienTich() {
		double p = tinhChuVi() / 2;
		return Math.sqrt(p * (p-a) * (p-b) * (p-c));
	}
	//Xuất thông tin
	public void xuatThongTin() {
		System.out.printf("Hình Tam Giác [3 cạnh: %.2f, %.2f, %.2f | Chu vi: %.2f | Diện tích: %.2f]\n", 
                a, b, c, tinhChuVi(), tinhDienTich());
	}
}
