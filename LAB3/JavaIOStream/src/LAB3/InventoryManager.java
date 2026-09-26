package LAB3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class InventoryManager {
    private static final Path CSV_PATH = Path.of("data", "inventory.csv");
    private static final Path REPORT_PATH = Path.of("data", "inventory-report.txt");

    public static void main(String[] args) {
        inputAndSaveProducts();
        List<Product> products = loadProductsFromCsv();
        
        if (!products.isEmpty()) {
            displayAndReport(products);
        }
    }

    // 1. Nhập từ bàn phím và ghi ra file CSV
    private static void inputAndSaveProducts() {
        Scanner sc = new Scanner(System.in);
        List<Product> tempProducts = new ArrayList<>();
        
        System.out.println("--- NHẬP DANH SÁCH SẢN PHẨM (Nhập 'q' ở Mã SP để dừng) ---");
        while (true) {
            try {
                System.out.print("Mã SP: ");
                String code = sc.nextLine();
                if (code.equalsIgnoreCase("q")) break;

                System.out.print("Tên SP: ");
                String name = sc.nextLine();
                System.out.print("Đơn giá: ");
                double price = Double.parseDouble(sc.nextLine());
                System.out.print("Số lượng: ");
                int qty = Integer.parseInt(sc.nextLine());

                tempProducts.add(new Product(code, name, price, qty));
                System.out.println("-> Đã thêm vào danh sách tạm.\n");
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Đơn giá và số lượng phải là số!");
            } catch (IllegalArgumentException e) {
                System.err.println("Lỗi dữ liệu: " + e.getMessage());
            }
        }

        // Ghi danh sách ra file inventory.csv
        try {
            Files.createDirectories(CSV_PATH.getParent());
            try (BufferedWriter writer = Files.newBufferedWriter(CSV_PATH, StandardCharsets.UTF_8)) {
                writer.write("ma,ten,donGia,soLuong"); // Header
                writer.newLine();
                for (Product p : tempProducts) {
                    writer.write(p.toCsvRow());
                    writer.newLine();
                }
            }
            System.out.println("Đã lưu " + tempProducts.size() + " sản phẩm vào " + CSV_PATH);
        } catch (IOException e) {
            System.err.println("Lỗi ghi tệp " + CSV_PATH + ": " + e.getMessage());
        }
    }

    // 2. Đọc file CSV và tái tạo danh sách đối tượng
    private static List<Product> loadProductsFromCsv() {
        List<Product> products = new ArrayList<>();
        if (!Files.exists(CSV_PATH)) {
            System.err.println("Không tìm thấy tệp dữ liệu: " + CSV_PATH.toAbsolutePath());
            return products;
        }

        try (BufferedReader reader = Files.newBufferedReader(CSV_PATH, StandardCharsets.UTF_8)) {
            reader.readLine(); // Bỏ qua dòng tiêu đề
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.isBlank()) continue;
                
                String[] parts = line.split(",", -1);
                if (parts.length != 4) {
                    System.err.println("Lỗi tại dòng " + lineNumber + " tệp CSV: Dữ liệu thiếu cột.");
                    continue;
                }

                try {
                    products.add(new Product(
                        parts[0].trim(), parts[1].trim(), 
                        Double.parseDouble(parts[2].trim()), 
                        Integer.parseInt(parts[3].trim())
                    ));
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi tại dòng " + lineNumber + " tệp CSV: Sai định dạng số.");
                } catch (IllegalArgumentException e) {
                    System.err.println("Lỗi tại dòng " + lineNumber + " tệp CSV: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi đọc tệp " + CSV_PATH + ": " + e.getMessage());
        }
        return products;
    }

    // 3. Hiển thị, tìm kiếm và xuất báo cáo
    private static void displayAndReport(List<Product> products) {
        double totalValue = 0;
        Product maxProduct = products.get(0);

        System.out.println("\n--- DANH SÁCH SẢN PHẨM ĐỌC TỪ CSV ---");
        for (Product p : products) {
            System.out.println(p);
            totalValue += p.inventoryValue();
            if (p.inventoryValue() > maxProduct.inventoryValue()) {
                maxProduct = p;
            }
        }

        System.out.printf("\nTổng giá trị tồn kho: %,.0f VND%n", totalValue);
        System.out.println("Sản phẩm có giá trị tồn kho cao nhất: " + maxProduct.toString());

        // Ghi báo cáo ra file inventory-report.txt
        try (BufferedWriter writer = Files.newBufferedWriter(REPORT_PATH, StandardCharsets.UTF_8)) {
            writer.write("--- BÁO CÁO TỒN KHO ---"); writer.newLine();
            writer.write("Tổng số sản phẩm: " + products.size()); writer.newLine();
            writer.write(String.format("Tổng giá trị tồn kho: %,.0f VND", totalValue)); writer.newLine();
            writer.write("Sản phẩm giá trị lớn nhất: " + maxProduct.toString()); writer.newLine();
            System.out.println("\n-> Đã xuất báo cáo thành công ra: " + REPORT_PATH);
        } catch (IOException e) {
            System.err.println("Lỗi ghi báo cáo " + REPORT_PATH + ": " + e.getMessage());
        }
    }
}
