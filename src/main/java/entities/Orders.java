package entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data

public class Orders {

  private Long orderId;
  private Long userId;
  private boolean active;
}
