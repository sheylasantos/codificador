public class Product extends Entity{
    private double price;
    private String name;

    public Product(String name,double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean validar(){
        if (price>0){
            return true;
        }
        return false;
    }
    public String fileName(){
        return "product: "+getName();
    }
}
