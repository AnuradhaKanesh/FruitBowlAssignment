import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Fruit {
    private String name;
    private String color;
    private String size;
}
