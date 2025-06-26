package service;

import functions.FruitBuyingFunction;
import model.FruitStand;

import java.util.List;
import java.util.stream.IntStream;

public class PriceOptimizerService {

    public static PurchaseInfo getOptimizedPurchaseLocationWithPrice(List<FruitStand> fruitStands, FruitBuyingFunction function) {
        return IntStream
                .range(0, fruitStands.size())
                .mapToObj(index ->
                        new PurchaseInfo(index, function.costOfFruitPurchase(fruitStands.get(index)))
                ).min(PurchaseInfo::compareTo)
                .orElseThrow();
    }

    public static int getOptimizedPurchaseLocation(List<FruitStand> fruitStands, FruitBuyingFunction function) {
        return getOptimizedPurchaseLocationWithPrice(fruitStands, function).standIndex;
    }

    public record PurchaseInfo(int standIndex, double cost) implements Comparable<PurchaseInfo>{
        @Override
        public int compareTo(PurchaseInfo o) {
            return Double.compare(cost, o.cost);
        }
    }
}
