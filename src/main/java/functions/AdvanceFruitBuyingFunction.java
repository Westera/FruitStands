package functions;

import model.Fruit;
import model.FruitStand;

import java.util.List;

public interface AdvanceFruitBuyingFunction {
    SpecifiedCost costOfFruitPurchase(FruitStand fruitStand);

    public record SpecifiedCost(double cost, List<Fruit> fruits) {
    }
}
