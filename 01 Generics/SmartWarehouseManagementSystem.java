import java.util.*;

abstract class WarehouseItem{
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDetails();
}

class Electronics extends WarehouseItem{
    private String brand;

    public Electronics(String name, String brand) {
        super(name);
        this.brand = brand;
    }

    @Override
    public String getDetails(){
        return "Electronics :"+getName()+" Brand: "+brand;
    }
}

class Groceries extends WarehouseItem{
    private String expiryDate;

    public Groceries(String name, String expiryDate) {
        super(name);
        this.expiryDate = expiryDate;
    }

    @Override
    public String getDetails(){
        return "Groceries: "+getName()+" Expiry Date: "+expiryDate;
    }
}

class Furniture extends WarehouseItem{
    private String material;

    public Furniture(String name, String material) {
        super(name);
        this.material = material;
    }

    @Override
    public String getDetails(){
        return "Furniture: "+getName()+" Material: "+material;
    }
}

class Storage<T extends WarehouseItem>{
    private List<T> items=new ArrayList<>();
    public void addItem(T item){
        items.add(item);
    }

    public List<T> getItems(){
        return items;
    }
}

class Warehouseutils{
    public static void displayItems(List<? extends WarehouseItem> items){
        for(WarehouseItem item:items){
            System.out.println(item.getDetails());
        }
    }
}

public class SmartWarehouseManagementSystem{
    public static void main(String[] args) {
        Storage<Electronics> elecStorage=new Storage<>();
        elecStorage.addItem(new Electronics("Laptop","Dell"));
        elecStorage.addItem(new Electronics("Phone","Samsung"));

        Storage<Groceries> grocStorage=new Storage<>();
        grocStorage.addItem(new Groceries("Milk","22-04-2025"));
        grocStorage.addItem(new Groceries("powder","26-04-2025"));

        Storage<Furniture> furnStorage=new Storage<>();
        furnStorage.addItem(new Furniture("chair","wood"));
        furnStorage.addItem(new Furniture("Table","Metal"));

        System.out.println("Electronics");
        Warehouseutils.displayItems(elecStorage.getItems());

        System.out.println("\nGroceries");
        Warehouseutils.displayItems(grocStorage.getItems());

        System.out.println("\nFurniture");
        Warehouseutils.displayItems(furnStorage.getItems());

    }
}