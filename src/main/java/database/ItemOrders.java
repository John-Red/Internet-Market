package database;

import lombok.Data;

@Data
public class ItemOrders {
  private Long itemId;
  private Long orderId;
  private Long itemOrderId;
  private Integer quantity;
}
