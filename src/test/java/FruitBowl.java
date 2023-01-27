import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Getter
public class FruitBowl {
    private List<Fruit> fruits;

    public void addFruits(Fruit... fruits) {
        this.fruits = Arrays.asList(fruits);
    }

    public FruitBowl(List<Fruit> fruits) {
        this.fruits = fruits;
    }
}
