package Main;

import functions.CherryAndPeachFunction;
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
        System.out.printf("You should stop at stand number %d%n", index + 1);
    }
}
