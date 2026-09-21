package LAB1B.Bai4;

import java.util.Scanner;
import LAB1B.Bai3.Person;

public class Student extends Person {
    private double gpa;
    private String email;

    // Khởi tạo không tham số
    public Student() {
        super();
    }

    // Khởi tạo đầy đủ tham số
    public Student(String name, String gender, String dob, String address, double gpa, String email) {
        super(name, gender, dob, address);
        this.gpa = gpa;
        this.email = email;
    }

    // Các phương thức get, set
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public void inputInfo() {
        super.inputInfo(); // Gọi hàm nhập của lớp cha (Person)
        Scanner sc = new Scanner(System.in);
        
        // Nhập và điều kiện kiểm tra Điểm trung bình (0.0 - 10.0)
        do {
            System.out.print("Nhập điểm trung bình (0.0 - 10.0): ");
            this.gpa = Double.parseDouble(sc.nextLine());
        } while (this.gpa < 0.0 || this.gpa > 10.0);

        // Nhập và điều kiện kiểm tra Email (có @ và không khoảng trắng)
        do {
            System.out.print("Nhập email (phải có @ và ko khoảng trắng): ");
            this.email = sc.nextLine();
        } while (!this.email.contains("@") || this.email.contains(" "));
    }

    @Override
    public void printInfo() {
        super.printInfo(); // Gọi hàm in của lớp cha (Person)
        System.out.println("Điểm TB: " + this.gpa + 
                           " | Email: " + this.email + 
                           " | Học bổng: " + (checkScholarship() ? "Có" : "Không"));
    }

    // Phương thức xét xem có được học bổng không (Điểm TB > 8.0)
    public boolean checkScholarship() {
        return this.gpa > 8.0;
    }
    public static void main(String[] args) {
        Student st = new Student();
        System.out.println("--- Nhập thông tin Sinh Viên ---");
        st.inputInfo();
        
        System.out.println("\n--- Thông tin Sinh Viên vừa nhập ---");
        st.printInfo();
    }
}
