package functions;

import model.Fruit;
import model.FruitStand;

public class CherryAndPeachFunction implements FruitBuyingFunction {
    @Override
    public double costOfFruitPurchase(FruitStand fruitStand) {
        return fruitStand.getPriceFor(Fruit.CHERRY) + fruitStand.getPriceFor(Fruit.PEACH);
    }
}
