package entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Cart {

  private String itemsImage;
  private String itemsName;
  private Integer itemsPrice;
  private Integer itemOrdersQuantity;
  private Integer itemOrderId;
}
