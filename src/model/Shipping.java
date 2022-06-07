package model;

import java.util.Random;

public class Shipping {
    Random random = new Random();
    private String id = "SP", name;
    private int price;

    public Shipping(String name, int price) {
        for(int i = 0; i < 3; i++){
            this.id += String.valueOf(random.nextInt(10));
        }
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
