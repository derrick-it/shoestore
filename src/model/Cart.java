package model;

public class Cart {
    private Shoes shoes;
    private int qty, size;

    public Cart(Shoes shoes, int qty, int size) {
        this.shoes = shoes;
        this.qty = qty;
        this.size = size;
    }


    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
