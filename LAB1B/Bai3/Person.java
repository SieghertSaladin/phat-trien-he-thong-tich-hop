package LAB1B.Bai3;

import java.util.Scanner;

public class Person {
    private String name;
    private String gender;
    private String dob; 
    private String address;

    // Phương thức khởi tạo không tham số
    public Person() {
    }

    // Phương thức khởi tạo đầy đủ tham số
    public Person(String name, String gender, String dob, String address) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    // Các phương thức get, set
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    // Phương thức nhập thông tin
    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        this.name = sc.nextLine();
        System.out.print("Nhập giới tính: ");
        this.gender = sc.nextLine();
        System.out.print("Nhập ngày sinh (dd/mm/yyyy): ");
        this.dob = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.address = sc.nextLine();
    }

    // Phương thức hiển thị thông tin
    public void printInfo() {
        System.out.println("Tên: " + this.name + 
                           " | Giới tính: " + this.gender + 
                           " | Ngày sinh: " + this.dob + 
                           " | Địa chỉ: " + this.address);
    }
    public static void main(String[] args) {
        Person p = new Person();
        System.out.println("--- Nhập thông tin ---");
        p.inputInfo();
        
        System.out.println("\n--- Hiển thị thông tin ---");
        p.printInfo();
    }
}
