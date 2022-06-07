package model;

import java.util.Random;

public class Customer extends User {
    private String name;
    private String address;

    public Customer(String username, String password, String name, String address) {
        super("C",username, password);
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
