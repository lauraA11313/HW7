package BouquetElements;

import BouquetElements.IBouquetElement;

abstract public class Flower implements IBouquetElement {
    private String name;
    private int price;
    private int daysOfFreshness;
    private int stemLength;

    public Flower(String name, int price, int daysToLive, int stemLength){
        this.name=name;
        this.price=price;
        this.daysOfFreshness=daysToLive;
        this.stemLength=stemLength;
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

    public int getDaysOfFreshness() {
        return daysOfFreshness;
    }

    public void setDaysOfFreshness(int daysOfFreshness) {
        this.daysOfFreshness = daysOfFreshness;
    }

    public int getStemLength() {
        return stemLength;
    }

    public void setStemLength(int stemLength) {
        this.stemLength = stemLength;
    }

    public String toString(){
        return String.format(getName()+" [price: "+getPrice()+", days of freshness: "+getDaysOfFreshness()+", stem length: "+getStemLength()+"]");
    }
}
