package LAB1B.Bai2;

import java.util.Arrays;
import java.util.Scanner;

public class IntArray {
    private int[] a;
    private int n; // Số lượng phần tử hiện có trong mảng

    // Khởi tạo mảng tối đa maxN phần tử
    public IntArray(int maxN) {
        a = new int[maxN];
        n = 0;
    }

    // Khởi tạo và nhập giá trị cho mảng từ bàn phím
    public void nhapMang(Scanner sc) {
        System.out.print("Nhập số lượng phần tử n (<= " + a.length + "): ");
        n = sc.nextInt();
        while (n < 0 || n > a.length) {
            System.out.print("Số lượng không hợp lệ. Nhập lại: ");
            n = sc.nextInt();
        }
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }
    }

    // Xuất thông tin của mảng[cite: 1]
    public void xuatMang() {
        if (n == 0) {
            System.out.println("Mảng rỗng!");
            return;
        }
        System.out.print("Mảng (" + n + " phần tử): [");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + (i < n - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    // Thêm một phần tử Y vào đầu mảng[cite: 1]
    public boolean themDau(int Y) {
        return themVaoViTri(0, Y);
    }

    // Thêm một phần tử Y vào cuối mảng[cite: 1]
    public boolean themCuoi(int Y) {
        return themVaoViTri(n, Y);
    }

    // Thêm một phần tử Y vào vị trí thứ i trong mảng[cite: 1]
    public boolean themVaoViTri(int pos, int Y) {
        if (n >= a.length) {
            System.out.println("Mảng đã đầy, không thể thêm!");
            return false;
        }
        if (pos < 0 || pos > n) {
            System.out.println("Vị trí thêm không hợp lệ!");
            return false;
        }
        for (int j = n; j > pos; j--) {
            a[j] = a[j - 1];
        }
        a[pos] = Y;
        n++;
        return true;
    }

    // Xóa phần tử thứ j trong mảng[cite: 1]
    public boolean xoaTaiViTri(int j) {
        if (j < 0 || j >= n) {
            System.out.println("Vị trí xóa không hợp lệ!");
            return false;
        }
        for (int k = j; k < n - 1; k++) {
            a[k] = a[k + 1];
        }
        n--;
        return true;
    }

    // Xóa phần tử giá trị X trong mảng (xóa tất cả xuất hiện của X)[cite: 1]
    public void xoaGiaTriX(int X) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == X) {
                xoaTaiViTri(i);
                i--; // Lùi chỉ số để không bỏ sót các phần tử kế tiếp
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không tìm thấy giá trị " + X + " trong mảng.");
        } else {
            System.out.println("Đã xóa " + count + " phần tử có giá trị " + X);
        }
    }

    // Tìm kiếm một phần tử B trong mảng chưa sắp xếp (Tuyến tính)[cite: 1]
    public int timKiemChuaSapXep(int B) {
        for (int i = 0; i < n; i++) {
            if (a[i] == B) return i;
        }
        return -1;
    }

    // Tìm kiếm một phần tử B trong mảng đã sắp xếp (Nhị phân)[cite: 1]
    public int timKiemDaSapXep(int B) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == B) return mid;
            if (a[mid] < B) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Sắp xếp mảng theo phương pháp Radix Sort[cite: 1]
    public void sapXepRadix(boolean tangDan) {
        if (n <= 1) return;

        // Tìm giá trị lớn nhất để biết số chữ số tối đa
        int max = Math.abs(a[0]);
        for (int i = 1; i < n; i++) {
            if (Math.abs(a[i]) > max) max = Math.abs(a[i]);
        }

        // Thực hiện Counting Sort cho từng chữ số (hang = 1, 10, 100,...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSortByDigit(exp);
        }

        // Nếu sắp xếp giảm dần, đảo ngược mảng lại[cite: 1]
        if (!tangDan) {
            for (int i = 0; i < n / 2; i++) {
                int temp = a[i];
                a[i] = a[n - 1 - i];
                a[n - 1 - i] = temp;
            }
        }
    }

    private void countSortByDigit(int exp) {
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            int digit = (Math.abs(a[i]) / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (Math.abs(a[i]) / exp) % 10;
            output[count[digit] - 1] = a[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, a, 0, n);
    }
}