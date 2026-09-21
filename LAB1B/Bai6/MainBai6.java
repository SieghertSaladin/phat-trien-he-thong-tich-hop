package LAB1B.Bai6;

//Lớp A
class A {
 int x; // Biến x của A
}

//Lớp B mở rộng A
class B extends A {
 int x; // Biến x của B
}

//Lớp C mở rộng B
class C extends B {
 int x; // Biến x của C

 // Phương thức trong C để đặt giá trị cho biến x của A
 public void setAX(int value) {
     // Ép kiểu 'this' về lớp A để truy cập đúng biến x của A
     ((A) this).x = value;
 }

 // Đặt giá trị cho biến x của B (để minh họa)
 public void setBX(int value) {
     super.x = value; 
 }

 // Đặt giá trị cho biến x của C (để minh họa)
 public void setCX(int value) {
     this.x = value;
 }

 // Phương thức in ra để kiểm chứng
 public void printValues() {
     System.out.println("Giá trị x của C (this.x): " + this.x);
     System.out.println("Giá trị x của B (super.x): " + super.x);
     System.out.println("Giá trị x của A (((A) this).x): " + ((A) this).x);
 }
}

//Lớp chạy thử nghiệm
public class MainBai6 {
	public static void main(String[] args) {
     C obj = new C();
     
     // Gán các giá trị khác nhau để chứng minh chúng hoàn toàn độc lập
     obj.setCX(30); 
     obj.setBX(20); 
     obj.setAX(10); // Đặt x của A thành 10 từ phương thức của C
     
     obj.printValues();
 }
}
