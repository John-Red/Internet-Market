package entities;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemOrders {

  private Long itemId;
  private Long orderId;
  private Long itemOrderId;
  private Integer quantity;

}

