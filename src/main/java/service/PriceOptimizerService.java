package service;

import functions.AdvanceFruitBuyingFunction;
import functions.FruitBuyingFunction;
import model.Fruit;
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

    public static DetailedPurchaseInfo getOptimizedPurchaseLocationWithDetails(List<FruitStand> fruitStands, AdvanceFruitBuyingFunction function) {
        return IntStream
                .range(0, fruitStands.size())
                .mapToObj(index -> {
                    AdvanceFruitBuyingFunction.SpecifiedCost specifiedCost = function.costOfFruitPurchase(fruitStands.get(index));
                    return new DetailedPurchaseInfo(specifiedCost.fruits(), new PurchaseInfo(index, specifiedCost.cost()));
                }).min(DetailedPurchaseInfo::compareTo)
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

    public record DetailedPurchaseInfo(List<Fruit> fruits, PurchaseInfo purchaseInfo) implements Comparable<DetailedPurchaseInfo>{
        @Override
        public int compareTo(DetailedPurchaseInfo o) {
            return Double.compare(purchaseInfo.cost, o.purchaseInfo().cost);
        }
    }
}
