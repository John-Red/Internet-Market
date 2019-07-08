package entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Items {

    private Long itemId;
    private String name;
    private Long categoryId;
    private Integer price;
    private Integer available;

    @Override
    public String toString() {
        return String.format(
                "Items: [id = %d, name = '%s', category_id = %s, price = %s, available = %s]",
                itemId, name, categoryId, price, available);
    }
}
