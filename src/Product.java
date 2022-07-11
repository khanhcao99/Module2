public class Product {
    private int productCode;
    private String name;
    private double price;
    private int amount;
    private String descripstion;

    public Product() {

    }

    public Product(int productCode, String name, double price, int amount, String descripstion) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.descripstion = descripstion;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescripstion() {
        return descripstion;
    }

    public void setDescripstion(String descripstion) {
        this.descripstion = descripstion;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode=" + productCode +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", descripstion='" + descripstion + '\'' +
                '}' + "\n";
    }
}
