package model;

import java.util.ArrayList;
import java.util.Random;

public class Order {
    Random random = new Random();
    private String id = "OR";
    private Customer customer;
    private ArrayList<Cart> cartShoes;

    public Order(Customer customer, ArrayList<Cart> cartShoes) {
        this.customer = customer;
        this.cartShoes = cartShoes;
        for(int i = 0; i < 3; i++){
            this.id += String.valueOf(random.nextInt(10));
        }
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Cart> getShoes() {
        return cartShoes;
    }

    public void setShoes(ArrayList<Cart> cartShoes) {
        this.cartShoes = cartShoes;
    }
}
