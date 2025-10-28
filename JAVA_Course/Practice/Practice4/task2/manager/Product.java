package Practice.Practice4.task2.manager;

import java.time.LocalDate;

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
}
