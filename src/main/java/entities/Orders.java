package entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class Orders {
    private Long orderId;
    private Long userId;
}
