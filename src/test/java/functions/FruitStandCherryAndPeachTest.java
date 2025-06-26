package functions;
import model.Fruit;
import model.FruitBasket;
import model.FruitStand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.PriceOptimizerService;

import java.util.List;


public class FruitStandCherryAndPeachTest {
    @Test
    public void TestGetIndexForSingleStand(){
        FruitStand fruitStand = new FruitStand(List.of(
                new FruitBasket(10, Fruit.CHERRY),
                new FruitBasket(50, Fruit.PEACH)));
        int expected = 0;
        int actual = PriceOptimizerService.getOptimizedPurchaseLocation(List.of(fruitStand), new CherryAndPeachFunction());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestGetIndexForCoupleOfStands(){
        List<FruitStand> fruitStands = List.of(
                new FruitStand(List.of(
                        new FruitBasket(10, Fruit.CHERRY),
                        new FruitBasket(50, Fruit.PEACH)))
                ,new FruitStand(List.of(
                        new FruitBasket(20, Fruit.CHERRY),
                        new FruitBasket(30, Fruit.PEACH))));

        int expected = 1;
        int actual = PriceOptimizerService.getOptimizedPurchaseLocation(fruitStands, new CherryAndPeachFunction());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestGetIndexForCoupleOfStandsReverse(){
        List<FruitStand> fruitStands = List.of(
                new FruitStand(List.of(
                        new FruitBasket(20, Fruit.CHERRY),
                        new FruitBasket(30, Fruit.PEACH)))
                ,new FruitStand(List.of(
                        new FruitBasket(10, Fruit.CHERRY),
                        new FruitBasket(50, Fruit.PEACH))));

        int expected = 0;
        int actual = PriceOptimizerService.getOptimizedPurchaseLocation(fruitStands, new CherryAndPeachFunction());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestGetIndexForMultipleOfStands(){
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

        int expected = 3;
        int actual = PriceOptimizerService.getOptimizedPurchaseLocation(fruitStands, new CherryAndPeachFunction());
        Assertions.assertEquals(expected, actual);
    }

}
