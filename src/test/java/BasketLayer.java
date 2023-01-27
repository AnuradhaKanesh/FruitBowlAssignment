import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BasketLayer {
    private String layerName;
    private FruitBowl fruitBowl;

    public BasketLayer(String layerName, FruitBowl fruitBowls) {
        this.layerName = layerName;
        this.fruitBowl = fruitBowls;
    }

}
