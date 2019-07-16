package entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemOrders {

  private Long itemOrderId;
  private Long itemId;
  private Long orderId;
  private Integer quantity;
}
