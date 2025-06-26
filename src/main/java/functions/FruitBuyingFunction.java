package functions;

import model.FruitStand;

@FunctionalInterface
public interface FruitBuyingFunction {
    double costOfFruitPurchase(FruitStand fruitStand);
}
