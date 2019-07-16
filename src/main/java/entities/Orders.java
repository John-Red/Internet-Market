package entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Orders {

  private Long orderId;
  private Long userId;
  private boolean active;
}
