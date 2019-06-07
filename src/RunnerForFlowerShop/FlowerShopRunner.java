package RunnerForFlowerShop;


import BouquetElements.Accessory;
import BouquetElements.Accessories.*;
import BouquetElements.Flower;
import BouquetElements.Flowers.*;
import FlowerShop.*;

import java.util.Scanner;

public class FlowerShopRunner {
    boolean exit;
    FlowerShop fs = new FlowerShop();


    public static void main(String[] args){
        FlowerShopRunner runner = new FlowerShopRunner();

        System.out.println("Flower Shop");
        runner.runMenu();
    }

    public void runMenu() {
        printHeader();
        fs.createBouquet();
        while (!exit) {
            printMenu1();
            System.out.println("\nCurrent bouquet price: "+ fs.bouquetPrice() + "$\n");
            int choice = getInput(3);
            switch (choice){
                case 0:
                    exit=true;
                    break;
                case 1:
                    int choice1=-1;
                    while(choice1!=0)
                        choice1= printMenu2(choice1);
                    break;
                case 2:
                    int choice5=-1;
                    while (choice5!=0)
                        choice5=bouquetOperationsMenu(choice5);
                    break;
                case 3:
                    String bouquet = fs.printBouquet(fs.getFlowers(), fs.getAccessories());
                    System.out.println(bouquet);
                    break;
            }
        }//////////////
    }

    public void printHeader(){
        System.out.println("\nFlower Shop\n");
    }

    public void printMenu1(){
        System.out.println("1 - Create bouquet");
        System.out.println("2 - Bouquets operations");
        System.out.println("3 - Print current bouquet");
        System.out.println("0 - Exit");
    }

    public int printMenu2(int choice1){
        System.out.println("1 - Add flower");
        System.out.println("2 - Add accessory");
        System.out.println("0 - Exit");
        choice1 = getInput(2);
        switch (choice1) {
            case 0:
                break;
            case 1:
                int choice2=-1;
                while (choice2!=0)
                    choice2 = addFlowerMenu(choice2);
                break;
            case 2:
                int choice3=-1;
                while (choice3!=0)
                    choice3 = addAccessoryMenu(choice3);

        }
        return choice1;
    }

    public int addFlowerMenu(int choice2){
        System.out.println("\nAdd a flower?\n");
        System.out.println("1 - Chamomile");
        System.out.println("2 - Iris");
        System.out.println("3 - Peony");
        System.out.println("4 - Rose");
        System.out.println("0 - Exit");
        choice2 = getInput(4);
        switch (choice2) {
            case 0:
                break;
            case 1:
                Flower chamomile = new Chamomile();
                fs.addFlowerToBouquet(chamomile);
                break;
            case 2:
                Flower iris = new Iris();
                fs.addFlowerToBouquet(iris);
                break;
            case 3:
                Flower peony = new Peony();
                fs.addFlowerToBouquet(peony);
                break;
            case 4:
                Flower rose = new Rose();
                fs.addFlowerToBouquet(rose);
                break;
        }
        return choice2;
    }

    public int addAccessoryMenu(int choice3){
        System.out.println("1 - Bow");
        System.out.println("2 - Card");
        System.out.println("3 - WrappingPaper");
        System.out.println("0 - Exit");
        choice3 = getInput(4);
        switch (choice3) {
            case 0:
                break;
            case 1:
                Accessory bow = new Bow();
                fs.addAccessoryToBouquet(bow);
                break;
            case 2:
                Accessory card = new Card();
                fs.addAccessoryToBouquet(card);
                break;
            case 3:
                Accessory wrappingPaper = new WrappingPaper();
                fs.addAccessoryToBouquet(wrappingPaper);
                break;
        }
        return choice3;
    }

    public int bouquetOperationsMenu(int choice4){
        System.out.println("1 - Add flower");
        System.out.println("2 - Add accessory");
        System.out.println("3 - Sort flowers by freshness");
        System.out.println("4 - Find flowers by stem length");
        System.out.println("0 - Exit");
        choice4=getInput(4);
        switch (choice4){
            case 0:
                break;
            case 1:
                int choice2=-1;
                while (choice2!=0)
                    choice2 = addFlowerMenu(choice2);
                break;
            case 2:
                int choice3=-1;
                while (choice3!=0)
                    choice3 = addAccessoryMenu(choice3);
                break;
            case 3:
                Flower [] flowers;
                flowers = fs.sortByDaysOfFreshness();
                for (Flower flower:flowers)
                    System.out.println(flower);
                break;
            case 4:
                Flower [] flowersFound;
                Scanner sc = new Scanner(System.in);
                System.out.println("Input min stem length: ");
                int minLength = Integer.parseInt(sc.nextLine());
                System.out.println("Input max stem length: ");
                int maxLength = Integer.parseInt(sc.nextLine());
                flowersFound=fs.findByStemLength(minLength, maxLength);
                for (Flower flower:flowersFound)
                    System.out.println(flower);
                break;

        }
        return choice4;
    }

    private int getInput(int numOfChoices){
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice>numOfChoices){
            try {
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Invalid selecion. Please try again.");
            }
        }
        return choice;
    }

}
