import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        int choice = -1;
        do {
            try {
                System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM-----");
                System.out.println("Chọn chức năng theo số (để tiếp tục)");
                System.out.println("1. Xem danh sách");
                System.out.println("2. Thêm mới");
                System.out.println("3. Cập nhập");
                System.out.println("4. Xóa");
                System.out.println("5. Sắp xếp");
                System.out.println("6. Tìm sản phẩm có giá đắt nhất");
                System.out.println("7. Đọc từ file");
                System.out.println("8. Ghi từ file");
                System.out.println("9. Thoát");
                System.out.println("Chọn chức năng: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        productManager.displayAll();
                        scanner.nextLine();

                        int choice2 = -1;
                        do {
                            try {
                                System.out.println("1. Thêm mới");
                                System.out.println("2. Cập nhập");
                                System.out.println("3. Xóa");
                                System.out.println("4. Thoát");
                                System.out.println("Chọn chức năng: ");
                                choice2 = Integer.parseInt(scanner.nextLine());
                                switch (choice2){
                                    case 1:
                                        productManager.addProduct();
                                        break;
                                    case 2:
                                        productManager.updateProduct();
                                        break;
                                    case 3:
                                        productManager.deleteProduct();
                                        break;

                                }
                            }catch (NumberFormatException e){
                                System.err.println("Nhập định dạng không đúng vui lòng nhập lại!");
                            }

                        }while (choice2 != 4 );

                        break;
                    case 2:
                        productManager.addProduct();
                        break;
                    case 3:
                        productManager.updateProduct();
                        break;
                    case 4:
                        productManager.deleteProduct();
                        break;
                    case 5:
                        int choice1;
                        System.out.println("-----Nhập sắp xếp theo giá-----");
                        System.out.println("1. Tăng dần         2. Giảm dần");
                        System.out.println("---->Lựa chọn của bạn:");
                        choice1 = Integer.parseInt(scanner.nextLine());
                        if (choice1 == 1){
                            productManager.displayUp();
                        }
                        if (choice1 == 2){
                            productManager.displayDown();
                        }
                        break;
                    case 6:
                        productManager.getProductHighestPrice();
                        break;
                    case 7:
                        productManager.writeFile();
                        break;
                    case 8:
                        productManager.readFile();
                        break;
                }
            }catch (NumberFormatException e){
                System.err.println("Nhập định dạng không đúng vui lòng nhập lại!");
            }

        }while (choice != 9);

    }
}
