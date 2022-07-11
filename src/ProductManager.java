import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager implements CRUD<Product> {
    private ArrayList <Product> products = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public ProductManager() {
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public boolean checkProductCode(int productCode){
        for (Product product: products){
            if (product.getProductCode() == productCode){
                return true;
            }
        }
        return false;
    }


    public Product addProduct() {
        Product product1 = createProduct();
        products.add(product1);
        return product1;
    }

    @Override
    public Product add(Product product) {
        products.add(product);
        System.out.println("Thêm mới thành công");
        return product;
    }

    public Product createProduct(){
            System.out.println("Nhập vào mã sản phẩm: ");
            int productCode = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập vào tên sản phẩm: ");
            String name = scanner.nextLine();
            System.out.println("Nhập vào giá sản phẩm: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhập vào số lượng sản phẩm: ");
            int amount = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập vào mô tả: ");
            String descripstion = scanner.nextLine();
            return new Product(productCode, name, price, amount, descripstion);

    }

    @Override
    public Product getById(int id) {
        for (Product product : products){
            if (product.getProductCode() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void updateById(int index, Product product) {
        products.set(index, product);
    }

    public int getIndexProduct(Product product){
        int index = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductCode() == product.getProductCode()){
                index = i;
                return index;
            }
        }
        return -1;
    }

    public void updateProduct(){
        System.out.println("Nhập mã sản phẩm muốn chỉnh sửa: ");
        int productCode1 = Integer.parseInt(scanner.nextLine());
        if (checkProductCode(productCode1)){
            Product product1 = getById(productCode1);
            int index = getIndexProduct(product1);
            System.out.println("Sản phẩm bạn muốn chỉnh sửa là: \n" + product1 );
            System.out.println("------------------------------------------------");
            System.out.println("Nhập vào mã sản phẩm mới: ");
            int productCode = Integer.parseInt(scanner.nextLine());
            product1.setProductCode(productCode);
            System.out.println("Nhập vào tên sản phẩm mới: ");
            String name = scanner.nextLine();
            product1.setName(name);
            System.out.println("Nhập vào giá sản phẩm mới: ");
            double price = Double.parseDouble(scanner.nextLine());
            product1.setPrice(price);
            System.out.println("Nhập vào số lượng sản phẩm mới: ");
            int amount = Integer.parseInt(scanner.nextLine());
            product1.setAmount(amount);
            System.out.println("Nhập vào mô tả mới: ");
            String descripstion = scanner.nextLine();
            product1.setDescripstion(descripstion);
            updateById(index,product1);
            System.out.println("Cập nhập thành công!");
        }else {
            System.out.println("Mã sản phẩm không tồn tại!");
        }
    }

    @Override
    public Product deleteById(int id) {
        for (Product product : products){
            if (product.getProductCode() == id){
                products.remove(product);
                return product;
            }
        }
        return null;
    }

    public void deleteProduct(){
        System.out.println("Nhập mã sản phẩm bạn muốn xóa: ");
        int productCode1 = Integer.parseInt(scanner.nextLine());
        if (checkProductCode(productCode1)){

            for (Product product : products){
                if(product.getProductCode() == productCode1){
                    System.out.println("Sản phẩm bạn muốn xóa là: ");
                    System.out.println(product);
                    System.out.println("Bạn có đông ý xóa sản phẩm không?");
                    System.out.println("1. Có                    2. Không");
                    System.out.println("Lựa chọn của bạn:");
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1){
                        products.remove(product);
                        System.out.println("Xóa thành công!");
                    }else {
                        break;
                    }
                    break;
                }
            }

            deleteById(productCode1);
        }else {
            System.out.println("Mã sản phẩm không tồn tại!");
        }
    }

    Comparator<Product> compareUp = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return (int) (o1.getPrice() - o2.getPrice());
        }
    } ;

    Comparator<Product> compareDown = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return (int) (o2.getPrice() - o1.getPrice());
        }
    } ;


    // Sắp xếp tăng dần
    public void displayUp(){
        System.out.println("Sản phẩm được sắp xếp tăng dần ...");
        products.sort(compareUp);
        displayAll();
    }

    public void displayDown(){
        System.out.println("Sản phẩm được sắp xếp giảm dần ...");
        products.sort(compareDown);
        displayAll();
    }

   public void getProductHighestPrice(){
        double price = 0;
        int index = 0;
       for (int i = 0; i < products.size(); i++) {
           if (products.get(i).getPrice() > price){
               price = products.get(i).getPrice();
               index = i;
           }
       }
       System.out.println(products.get(index));
   }

    @Override
    public Product deleteByAll() {
        return null;
    }

    @Override
    public void displayByid(int id) {

    }

    @Override
    public void displayAll() {
        for (Product product: products){
            System.out.println(product);
        }
    }

    public void writeFile(){
        write(products);
    }

    public void readFile(){
        setProducts(read());
        displayAll();
    }

    public void write(ArrayList<Product> products){
        File file = new File("C:\\Users\\ASUS\\Desktop\\Module2\\src\\data\\products.csv");
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Product product : products){
                bufferedWriter.write(product.getProductCode() + "," + product.getName() + "," + product.getPrice() + "," + product.getAmount() + "," + product.getDescripstion() +"\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public ArrayList<Product> read(){
        ArrayList<Product> products1 = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\ASUS\\Desktop\\Module2\\src\\data\\products.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                Product product = new Product(Integer.parseInt(strings[0]),strings[1] ,Double.parseDouble(strings[2]),Integer.parseInt(strings[3]),strings[4]);
                products1.add(product);
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products1;
    }
}
