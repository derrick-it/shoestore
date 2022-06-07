package model;

import java.util.Random;

public class Shoes {
    Random random = new Random();
    private String id = "S";
    private String name;
    private String brand;
    private int sizeMin;
    private int sizeMax;
    private int stock;
    private int price;

    public Shoes( String name, String brand, int sizeMin, int sizeMax, int stock, int price) {
        for(int i = 0; i < 3; i++){
            this.id += String.valueOf(random.nextInt(10));
        }
        this.name = name;
        this.brand = brand;
        this.sizeMin = sizeMin;
        this.sizeMax = sizeMax;
        this.stock = stock;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSizeMin() {
        return sizeMin;
    }

    public void setSizeMin(int sizeMin) {
        this.sizeMin = sizeMin;
    }

    public int getSizeMax() {
        return sizeMax;
    }

    public void setSizeMax(int sizeMax) {
        this.sizeMax = sizeMax;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
