package LAB1B.Bai7;

import java.util.Scanner;

interface Polygon {
    double area();
    double perimeter();
}

class Triangle implements Polygon {
    protected double a, b, c;
    public Triangle(double a, double b, double c) { this.a = a; this.b = b; this.c = c; }
    public double perimeter() { return a + b + c; }
    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double a, double b) { super(a, a, b); } // 2 cạnh a bằng nhau, cạnh đáy b
}

class EquilateralTriangle extends IsoscelesTriangle {
    public EquilateralTriangle(double a) { super(a, a); } // 3 cạnh bằng nhau
}

class Quadrilateral implements Polygon {
    protected double a, b, c, d;
    public Quadrilateral(double a, double b, double c, double d) {
        this.a = a; this.b = b; this.c = c; this.d = d;
    }
    public double perimeter() { return a + b + c + d; }
    public double area() { return 0; } // Cần thêm góc hoặc đường chéo để tính diện tích tứ giác thường
}

class Rectangle extends Quadrilateral {
    public Rectangle(double width, double height) { super(width, height, width, height); }
    @Override
    public double area() { return a * b; }
}

class Square extends Rectangle {
    public Square(double side) { super(side, side); }
}

// Giả sử các đa giác dưới đây là đa giác đều (Regular Polygons) để tính diện tích từ 1 cạnh
class Pentagon implements Polygon {
    private double a;
    public Pentagon(double a) { this.a = a; }
    public double perimeter() { return 5 * a; }
    public double area() { return (Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * a * a) / 4; }
}

class Hexagon implements Polygon {
    private double a;
    public Hexagon(double a) { this.a = a; }
    public double perimeter() { return 6 * a; }
    public double area() { return (3 * Math.sqrt(3) * a * a) / 2; }
}

class Octagon implements Polygon {
    private double a;
    public Octagon(double a) { this.a = a; }
    public double perimeter() { return 8 * a; }
    public double area() { return 2 * (1 + Math.sqrt(2)) * a * a; }
}

public class MainBai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chọn đa giác: 1.Tam giác đều 2.Hình chữ nhật 3.Hình vuông 4.Lục giác đều");
        System.out.print("Lựa chọn: ");
        int choice = sc.nextInt();
        Polygon p = null;

        switch (choice) {
            case 1:
                System.out.print("Nhập cạnh tam giác đều: ");
                p = new EquilateralTriangle(sc.nextDouble());
                break;
            case 2:
                System.out.print("Nhập chiều dài và chiều rộng: ");
                p = new Rectangle(sc.nextDouble(), sc.nextDouble());
                break;
            case 3:
                System.out.print("Nhập cạnh hình vuông: ");
                p = new Square(sc.nextDouble());
                break;
            case 4:
                System.out.print("Nhập cạnh lục giác đều: ");
                p = new Hexagon(sc.nextDouble());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return;
        }

        System.out.println("Chu vi: " + p.perimeter());
        System.out.println("Diện tích: " + p.area());
    }
}