package entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Categories {

  private Long categoryId;
  private String name;
}
