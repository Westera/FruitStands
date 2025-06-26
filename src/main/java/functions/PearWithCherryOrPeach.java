package functions;

import model.Fruit;
import model.FruitStand;

public class PearWithCherryOrPeach implements FruitBuyingFunction{

    @Override
    public double costOfFruitPurchase(FruitStand fruitStand) {
        return fruitStand.getPriceFor(Fruit.PEAR) +
                Math.min(fruitStand.getPriceFor(Fruit.PEACH), fruitStand.getPriceFor(Fruit.CHERRY));
    }
}
