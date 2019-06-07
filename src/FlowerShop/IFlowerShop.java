package FlowerShop;

import BouquetElements.Accessory;
import BouquetElements.Flower;

public interface IFlowerShop {
    void createBouquet();
    void addFlowerToBouquet(Flower flower);
    void addAccessoryToBouquet(Accessory accessory);
    Flower [] extendFlowerArrayByNewFlower(Flower flowerToAdd, Flower [] flowers);
    Accessory [] extendAccessoryArrayByNewAccessory(Accessory accessoryToAdd, Accessory [] accessories);
    String printBouquet(Flower [] flowers, Accessory [] accessories);
    Flower [] sortByDaysOfFreshness();
    Flower[] findByStemLength(int minLength, int maxLength);
    int bouquetPrice();
}
