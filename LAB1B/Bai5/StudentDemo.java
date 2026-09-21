package LAB1B.Bai5;

import java.util.Scanner;
import LAB1B.Bai4.Student;

public class StudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên n = ");
        int n = Integer.parseInt(sc.nextLine());

        Student[] listStudent = new Student[n];

        // 1. Nhập vào n sinh viên
        for (int i = 0; i < n; i++) {
            System.out.println("--- Nhập sinh viên thứ " + (i + 1) + " ---");
            listStudent[i] = new Student();
            listStudent[i].inputInfo();
        }

        // 2. Hiển thị tất cả sinh viên
        System.out.println("\n--- DANH SÁCH TẤT CẢ SINH VIÊN ---");
        for (Student st : listStudent) {
            st.printInfo();
        }

        // 3. Hiển thị SV có điểm trung bình cao nhất và thấp nhất
        if (n > 0) {
            double maxGpa = listStudent[0].getGpa();
            double minGpa = listStudent[0].getGpa();

            // Tìm giá trị cao nhất và thấp nhất
            for (Student st : listStudent) {
                if (st.getGpa() > maxGpa) maxGpa = st.getGpa();
                if (st.getGpa() < minGpa) minGpa = st.getGpa();
            }

            System.out.println("\n--- SINH VIÊN CÓ ĐIỂM TB CAO NHẤT (" + maxGpa + ") ---");
            for (Student st : listStudent) {
                if (st.getGpa() == maxGpa) st.printInfo();
            }

            System.out.println("\n--- SINH VIÊN CÓ ĐIỂM TB THẤP NHẤT (" + minGpa + ") ---");
            for (Student st : listStudent) {
                if (st.getGpa() == minGpa) st.printInfo();
            }
        }

        // 4. Hiển thị tất cả SV được học bổng
        System.out.println("\n--- DANH SÁCH SINH VIÊN ĐƯỢC HỌC BỔNG ---");
        boolean hasScholarship = false;
        for (Student st : listStudent) {
            if (st.checkScholarship()) {
                st.printInfo();
                hasScholarship = true;
            }
        }
        if (!hasScholarship) {
            System.out.println("Không có sinh viên nào đạt học bổng.");
        }
    }
}
