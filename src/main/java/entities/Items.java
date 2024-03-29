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
  private String image;
}
