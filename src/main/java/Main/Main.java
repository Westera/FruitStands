package Main;

import functions.AdvancePearWithCherryOrPeach;
import functions.CherryAndPeachFunction;
import functions.PearWithCherryOrPeach;
import model.Fruit;
import model.FruitBasket;
import model.FruitStand;
import service.PriceOptimizerService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FruitStand> fruitStands = List.of(
                new FruitStand(List.of(
                        new FruitBasket(20, Fruit.CHERRY),
                        new FruitBasket(30, Fruit.PEACH)))
                ,new FruitStand(List.of(
                        new FruitBasket(10, Fruit.CHERRY),
                        new FruitBasket(50, Fruit.PEACH)))
                ,new FruitStand(List.of(
                        new FruitBasket(70, Fruit.CHERRY),
                        new FruitBasket(50, Fruit.PEACH)))
                ,new FruitStand(List.of(
                        new FruitBasket(40, Fruit.CHERRY),
                        new FruitBasket(4, Fruit.PEACH)))
                ,new FruitStand(List.of(
                        new FruitBasket(300, Fruit.CHERRY),
                        new FruitBasket(20, Fruit.PEACH)))
        );
        int index = PriceOptimizerService.getOptimizedPurchaseLocation(fruitStands, new CherryAndPeachFunction());
        System.out.printf("Task 1: You should stop at stand number %d%n", index + 1);

        fruitStands = List.of(
                new FruitStand(List.of(
                        new FruitBasket(20, Fruit.CHERRY),
                        new FruitBasket(30, Fruit.PEACH),
                        new FruitBasket(100, Fruit.PEAR)))
                ,new FruitStand(List.of(
                        new FruitBasket(10, Fruit.CHERRY),
                        new FruitBasket(50, Fruit.PEACH),
                        new FruitBasket(100, Fruit.PEAR)))
                ,new FruitStand(List.of(
                        new FruitBasket(70, Fruit.CHERRY),
                        new FruitBasket(50, Fruit.PEACH),
                        new FruitBasket(100, Fruit.PEAR)))
                ,new FruitStand(List.of(
                        new FruitBasket(40, Fruit.CHERRY),
                        new FruitBasket(4, Fruit.PEACH),
                        new FruitBasket(100, Fruit.PEAR)))
                ,new FruitStand(List.of(
                        new FruitBasket(300, Fruit.CHERRY),
                        new FruitBasket(20, Fruit.PEACH),
                        new FruitBasket(100, Fruit.PEAR)))
        );

        PriceOptimizerService.PurchaseInfo purchaseInfo = PriceOptimizerService.getOptimizedPurchaseLocationWithPrice(fruitStands, new PearWithCherryOrPeach());
        System.out.printf("Task 2: You should stop at stand number %d and it will cost: %.2f%n", purchaseInfo.standIndex() + 1, purchaseInfo.cost());

        PriceOptimizerService.DetailedPurchaseInfo detailedPurchaseInfo = PriceOptimizerService.getOptimizedPurchaseLocationWithDetails(fruitStands, new AdvancePearWithCherryOrPeach());
        System.out.printf("Task 2: You should stop at stand number %d and it will cost: %.2f there you will get %s%n", detailedPurchaseInfo.purchaseInfo().standIndex() + 1, detailedPurchaseInfo.purchaseInfo().cost(), detailedPurchaseInfo.fruits());
    }
}
