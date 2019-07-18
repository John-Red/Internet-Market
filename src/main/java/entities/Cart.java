package entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class Cart {

  private String itemsImage;
  private String itemsName;
  private Integer itemsPrice;
  private Integer itemOrdersQuantity;
  private Long itemOrderId;
  private Integer totalPrice;
}
