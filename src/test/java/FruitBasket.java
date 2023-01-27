import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public class FruitBasket {
    private List<BasketLayer> basketLayers;

    public FruitBasket() {
    }

    public void sortFruitsIntoBasketLayer(FruitBowl fruitBowl, String sortType) {
        switch (sortType) {
            case "name":
                basketLayers = fruitBowl.getFruits().stream()
                        .collect(Collectors.groupingBy(Fruit::getName))
                        .entrySet().stream()
                        .map(
                                entry -> new BasketLayer(
                                        entry.getKey(),
                                        new FruitBowl(entry.getValue())
                                )
                        ).collect(Collectors.toList());
                break;

            case "color":
                basketLayers = fruitBowl.getFruits().stream()
                        .collect(Collectors.groupingBy(Fruit::getColor))
                        .entrySet().stream()
                        .map(
                                entry -> new BasketLayer(
                                        entry.getKey(),
                                        new FruitBowl(entry.getValue())
                                )
                        ).collect(Collectors.toList());
                break;

            case "size":
                basketLayers = fruitBowl.getFruits().stream()
                        .collect(Collectors.groupingBy(Fruit::getSize))
                        .entrySet().stream()
                        .map(
                                entry -> new BasketLayer(
                                        entry.getKey(),
                                        new FruitBowl(entry.getValue())
                                )
                        ).collect(Collectors.toList());
                break;

            default:
                basketLayers = null;
                break;
        }
    }

    public void showFruitBasket() {
        IntStream.range(0, basketLayers.size())
                .mapToObj(index -> String.format("%s -> %s",
                        basketLayers.get(index).getLayerName(), basketLayers.get(index).getFruitBowl().getFruits()
                                .stream().map(Fruit::getName).collect(Collectors.joining(", "))))

                .forEach(System.out::println);
    }
}
