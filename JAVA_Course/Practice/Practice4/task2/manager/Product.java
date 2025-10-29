package Practice.Practice4.task2.manager;

import java.time.LocalDate;
import java.util.Comparator;

public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private LocalDate launchDate;

    public Product(){
    };

    public Product(String id, String name, double price, int quantity, LocalDate launchDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.launchDate = launchDate;
    };

    public Product(Product other){
        this.id=other.id;
        this.name=other.name;
        this.price=other.price;
        this.quantity=other.quantity;
        this.launchDate=other.launchDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public static Comparator<Product> byID(){
        return Comparator.comparing(Product::getId);
    }

    public Product copy(){
        return new Product(this);
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null||getClass()!=obj.getClass()) return false;
        Product product=(Product)obj;
        return this.id.equals(product.id);
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }




}
