package functions;

import model.Fruit;
import model.FruitBasket;
import model.FruitStand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.PriceOptimizerService;

import java.util.List;

public class PearWithCherryOrPeachTest {

    @Test
    public void TestGetIndexForSingleStand(){
        FruitStand fruitStand = new FruitStand(List.of(
                new FruitBasket(10, Fruit.CHERRY),
                new FruitBasket(50, Fruit.PEACH),
                new FruitBasket(100, Fruit.PEAR)));
        PriceOptimizerService.PurchaseInfo expected = new PriceOptimizerService.PurchaseInfo(0, 110);
        PriceOptimizerService.PurchaseInfo actual = PriceOptimizerService.getOptimizedPurchaseLocationWithPrice(List.of(fruitStand), new PearWithCherryOrPeach());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestGetIndexForCoupleOfStands(){
        List<FruitStand> fruitStands = List.of(
                new FruitStand(List.of(
                        new FruitBasket(10, Fruit.CHERRY),
                        new FruitBasket(50, Fruit.PEACH),
                        new FruitBasket(100, Fruit.PEAR)))
                ,new FruitStand(List.of(
                        new FruitBasket(20, Fruit.CHERRY),
                        new FruitBasket(30, Fruit.PEACH),
                        new FruitBasket(100, Fruit.PEAR))));

        PriceOptimizerService.PurchaseInfo expected = new PriceOptimizerService.PurchaseInfo(0, 110);
        PriceOptimizerService.PurchaseInfo actual = PriceOptimizerService.getOptimizedPurchaseLocationWithPrice(fruitStands, new PearWithCherryOrPeach());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestGetIndexForCoupleOfStandsReverse(){
        List<FruitStand> fruitStands = List.of(
                new FruitStand(List.of(
                        new FruitBasket(20, Fruit.CHERRY),
                        new FruitBasket(30, Fruit.PEACH),
                        new FruitBasket(100, Fruit.PEAR)))
                ,new FruitStand(List.of(
                        new FruitBasket(10, Fruit.PEACH),
                        new FruitBasket(50, Fruit.CHERRY),
                        new FruitBasket(100, Fruit.PEAR))));

        PriceOptimizerService.PurchaseInfo expected = new PriceOptimizerService.PurchaseInfo(1, 110);
        PriceOptimizerService.PurchaseInfo actual = PriceOptimizerService.getOptimizedPurchaseLocationWithPrice(fruitStands, new PearWithCherryOrPeach());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestGetIndexForMultipleOfStands(){
        List<FruitStand> fruitStands = List.of(
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

        PriceOptimizerService.PurchaseInfo expected = new PriceOptimizerService.PurchaseInfo(3, 104);
        PriceOptimizerService.PurchaseInfo actual = PriceOptimizerService.getOptimizedPurchaseLocationWithPrice(fruitStands, new PearWithCherryOrPeach());
        Assertions.assertEquals(expected, actual);
    }
}
