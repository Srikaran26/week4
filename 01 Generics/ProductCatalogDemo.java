import java.util.ArrayList;
import java.util.List;

interface Category{
    String getName();

}

class BookCategory implements Category{
    private final String name;

    public BookCategory(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

class ClothingCategory implements Category{
    private final String name;

    public ClothingCategory(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

class Product<T extends Category>{
    private String PName;
    private double price;
    private T Category;

    public Product(String PName, double price, T category) {
        this.PName = PName;
        this.price = price;
        Category = category;
    }

    public String getPName(){
        return PName;
    }

    public double getPrice(){
        return price;
    }

    public T getCategory() {
        return Category;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public String display(){
        return String.format("Product{ name='%s', price=%.2f, category=%s}",PName,price, Category.getName());
    }
}

class Discount{
    public static <T extends Category> void applyDiscount(Product<T> product,double percentage){
        double discountedPrice=product.getPrice()*(1-percentage/100);
        product.setPrice(discountedPrice);
    }
}

public class ProductCatalogDemo{
    public static void main(String[] args) {
        BookCategory comic=new BookCategory("comic");
        ClothingCategory mens=new ClothingCategory("Mens");

        Product<BookCategory> book=new Product<>("Death Note",5000,comic);
        Product<ClothingCategory> shirt=new Product<>("TShirt",2000,mens);

        List<Product<? extends Category>> list=new ArrayList<>();
        list.add(book);
        list.add(shirt);

        Discount.applyDiscount(book,10);
        Discount.applyDiscount(shirt,30);

        for(Product<? extends Category> product: list){
            System.out.println(product.display());
        }
    }
}


