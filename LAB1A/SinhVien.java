package LAB1;

import java.util.ArrayList;

public class SinhVien {
	private String mssv;
	private String ten;
	private int tuoi;
	private ArrayList<MonHoc> listMH;
	
	
	public SinhVien(String mssv, String ten, int tuoi, ArrayList<MonHoc> listMH) {
		this.mssv = mssv;
		this.ten = ten;
		this.tuoi = tuoi;
		this.listMH = listMH;
	}


	public String getMssv() {
		return mssv;
	}
	public String getTen() {
		return ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public ArrayList<MonHoc> getListMH(){
		return listMH;
	}

}
