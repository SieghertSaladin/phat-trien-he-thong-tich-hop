package LAB1;

public class MonHoc {
	private String tenMonHoc;
	private int tinChi;
	private double diem;
	
	public MonHoc(String tenMonHoc, int tinChi, double diem) {
		this.tenMonHoc = tenMonHoc;
		this.tinChi = tinChi;
		this.diem = diem;
	}
	
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	
	public int getTinChi() {
		return tinChi;
	}
	
	public double getDiem() {
		return diem;
	}
	

}
