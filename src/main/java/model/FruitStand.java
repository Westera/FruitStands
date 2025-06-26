package model;

import java.util.List;

public class FruitStand {
    private List<FruitBasket> availableBaskets;

    public FruitStand(List<FruitBasket> availableBaskets) {
        this.availableBaskets = availableBaskets;
    }

    public double getPriceFor(Fruit fruit) {
        return availableBaskets.stream()
                .filter(basket -> basket.fruit() == fruit)
                .findFirst()
                .map(FruitBasket::price)
                .orElseThrow();
    }
}
