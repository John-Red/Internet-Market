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
  private Long itemOrderId;
  private Integer totalPrice;

  public Integer getTotalPrice() {
    return itemsPrice * itemOrdersQuantity;
  }
}
