package functions;

import model.Fruit;
import model.FruitStand;

import java.util.ArrayList;
import java.util.List;

public class AdvancePearWithCherryOrPeach implements AdvanceFruitBuyingFunction{
    @Override
    public SpecifiedCost costOfFruitPurchase(FruitStand fruitStand) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(Fruit.PEAR);
        double cost = fruitStand.getPriceFor(Fruit.PEAR);

        if (fruitStand.getPriceFor(Fruit.CHERRY) < fruitStand.getPriceFor(Fruit.PEACH) ) {
            cost += fruitStand.getPriceFor(Fruit.CHERRY);
            fruits.add(Fruit.CHERRY);
        } else if (fruitStand.getPriceFor(Fruit.PEACH) < fruitStand.getPriceFor(Fruit.CHERRY) ) {
            cost += fruitStand.getPriceFor(Fruit.PEACH);
            fruits.add(Fruit.PEACH);
        }

        return new SpecifiedCost(cost, fruits);
    }
}
