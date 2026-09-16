package LAB1;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WriteBinaryFile {
	
	public static void saveSV(String src,ArrayList<SinhVien>listSV) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(src)));
		dos.writeInt(listSV.size());
		for(SinhVien sv : listSV) {
			dos.writeUTF(sv.getMssv());
			dos.writeUTF(sv.getTen());
			dos.writeInt(sv.getTuoi());
			dos.writeInt(sv.getListMH().size());
			for(MonHoc mh : sv.getListMH()) {
				dos.writeUTF(mh.getTenMonHoc());
				dos.writeInt(mh.getTinChi());
				dos.writeDouble(mh.getDiem());
			}
		}
		dos.flush();
		dos.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MonHoc mh = new MonHoc("ltcb", 3, 6.7);
		MonHoc mh1 = new MonHoc("ltw", 3, 6.7);
		MonHoc mh2 = new MonHoc("tkhdt", 3, 6.7);
		ArrayList<MonHoc> listMH = new ArrayList<>();
		listMH.add(mh2);
		listMH.add(mh1);
		listMH.add(mh);
		ArrayList<SinhVien> listSV = new ArrayList<>();
		SinhVien sv = new SinhVien("11329078", "Nguyen Van A", 23, listMH);
		SinhVien sv1 = new SinhVien("11329078", "Nguyen Van B", 23, listMH);
		listSV.add(sv);
		listSV.add(sv1);
		saveSV("D:\\a.txt", listSV);
	}

}
