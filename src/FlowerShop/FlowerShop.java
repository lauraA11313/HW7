package FlowerShop;

import BouquetElements.Accessory;
import BouquetElements.Flower;

public class FlowerShop implements IFlowerShop{

    private Flower[]flowers;
    private Accessory[]accessories;

    public void createBouquet(){
        flowers=new Flower[0];
        accessories=new Accessory[0];
    }

    public void addFlowerToBouquet(Flower flower){
        flowers=extendFlowerArrayByNewFlower(flower, getFlowers());
    }

    public void addAccessoryToBouquet(Accessory accessory){
        accessories=extendAccessoryArrayByNewAccessory(accessory, getAccessories());
    }

    public Flower [] extendFlowerArrayByNewFlower(Flower flowerToAdd, Flower [] flowers){
        Flower[] newFlowerArray=new Flower[flowers.length+1];
        for (int i=0; i<flowers.length;i++)
            newFlowerArray[i]=flowers[i];
        newFlowerArray[flowers.length] = flowerToAdd;
        return newFlowerArray;
    }

    public Accessory [] extendAccessoryArrayByNewAccessory(Accessory accessoryToAdd, Accessory [] accessories){
        Accessory[] newAccessoryArray=new Accessory[accessories.length+1];
        for (int i=0; i<accessories.length;i++)
            newAccessoryArray[i]=accessories[i];
        newAccessoryArray[accessories.length] = accessoryToAdd;
        return newAccessoryArray;
    }

    public String printBouquet(Flower [] flowers, Accessory [] accessories){
        String result = "Current bouquet\n Flowers:\n\t";
        for (Flower flower : flowers) {
            result += (flower.toString() + "\n");
        }
        result+="Accessories:\n\t";
        for (Accessory accessory : accessories) {
            result+=(accessory.toString() +"\n");
        }
        return result;
    }

    public Flower [] sortByDaysOfFreshness(){
        for (int i=0; i<flowers.length;i++){
            for (int j=0; j<flowers.length;j++){
                if (flowers[j].getDaysOfFreshness() < flowers[i].getDaysOfFreshness()){
                    Flower temp = flowers[j];
                    flowers[j]=flowers[i];
                    flowers[i]=temp;
                }
            }
        }
        return flowers;
    }

    public Flower[] findByStemLength(int minLength, int maxLength){
        Flower [] res={};

        for (Flower flower : getFlowers()) {
            if (flower.getStemLength()>=minLength&&flower.getStemLength()<=maxLength){
                res = extendFlowerArrayByNewFlower(flower,res);
            }
        }
        return res;
    }

    public int bouquetPrice(){
        int sum=0;
        if(flowers.length==0){}
        else{
        for(Flower flower : getFlowers())
            sum+=flower.getPrice();}
        if(accessories.length==0){}
        else {
            for (Accessory accessory : getAccessories())
                sum += accessory.getPrice();
        }
        return sum;
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public Accessory[] getAccessories() {
        return accessories;
    }

}
