package entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class Items {

    private Long itemId;
    private String name;
    private Long categoryId;
    private Integer price;
    private Integer available;

}
