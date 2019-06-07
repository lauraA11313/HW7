package BouquetElements;

import BouquetElements.IBouquetElement;

abstract public class Accessory implements IBouquetElement {
    private String name;
    private int price;

    public Accessory(String name, int price) {
        this.name = name;
        this.price = price;
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

    public String toString() {
        return String.format(getName() + " [price: " + getPrice() + "]");
    }
}
