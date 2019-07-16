package entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cart {

  private Long id;
  private Long userId;
  private Long itemId;
  private Integer quantity;
}