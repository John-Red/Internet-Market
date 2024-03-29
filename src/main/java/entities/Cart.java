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
  private Long itemId;
  private Integer totalPrice;
  private Long orderId;

  public static Long currentUserId;

  public Integer getTotalPrice() {
    return itemsPrice * itemOrdersQuantity;
  }
}
