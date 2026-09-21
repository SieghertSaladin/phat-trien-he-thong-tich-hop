package LAB1B.Bai1;

public class DemoHinh {

	public static void main(String[] args) {
		System.out.println("Thông tin các hình: ");
		// Khởi tạo đối tượng HCN
		HCN hcn = new HCN (6.0, 3.0);
		hcn.xuatThongTin();
		
		//Khởi tạo đối tượng HinhVuong
		HinhVuong hv = new HinhVuong(3.0);
		hv.xuatThongTin();
		
		// Khởi tạo đối tượng HinhTamGiac
		HinhTamGiac htg = new HinhTamGiac(2.0, 3.0, 4.0);
		htg.xuatThongTin();
	}
}
