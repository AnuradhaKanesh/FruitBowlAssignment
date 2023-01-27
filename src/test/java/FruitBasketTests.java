import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FruitBasketTests {

    Fruit apple1, apple2, orange1, orange2, orange3, grape1, grape2, grape3;
    FruitBowl mixedFruitBowl;

    @BeforeTest
    public void addFruits() {

        apple1 = new Fruit.FruitBuilder().color("Red").size("Small").name("Apple").build();
        apple2 = new Fruit.FruitBuilder().color("Red").size("Medium").name("Apple").build();
        orange1 = new Fruit.FruitBuilder().color("Orange").size("Medium").name("Orange").build();
        orange2 = new Fruit.FruitBuilder().color("Orange").size("Small").name("Orange").build();
        orange3 = new Fruit.FruitBuilder().color("Orange").size("Large").name("Orange").build();
        grape1 = new Fruit.FruitBuilder().color("Green").size("Small").name("Grape").build();
        grape2 = new Fruit.FruitBuilder().color("Black").size("Small").name("Grape").build();
        grape3 = new Fruit.FruitBuilder().color("Red").size("Small").name("Grape").build();

        mixedFruitBowl = new FruitBowl();
        mixedFruitBowl.addFruits(apple1, apple2, orange1, orange2, orange3, grape1, grape2, grape3);

    }


    @Test
    public void testSortedFruitBasketWithName() {
        // 1. Arrange
        FruitBasket fruitBasket = new FruitBasket();

        // 2. Act
        fruitBasket.sortFruitsIntoBasketLayer(mixedFruitBowl, "name");
        fruitBasket.showFruitBasket();

        // 3. Assert
        Assert.assertEquals(fruitBasket.getBasketLayers().size(), 3);
    }


    @Test
    public void testSortedFruitBasketWithSize() {
        FruitBasket fruitBasket = new FruitBasket();
        fruitBasket.sortFruitsIntoBasketLayer(mixedFruitBowl, "size");
        fruitBasket.showFruitBasket();
        Assert.assertEquals(fruitBasket.getBasketLayers().size(), 3);
    }

    @Test
    public void testSortedFruitBasketWithColor() {
        FruitBasket fruitBasket = new FruitBasket();
        fruitBasket.sortFruitsIntoBasketLayer(mixedFruitBowl, "color");
        fruitBasket.showFruitBasket();
        Assert.assertEquals(fruitBasket.getBasketLayers().size(), 4);
    }

}
