package entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class Categories {

  private Long categoryId;
  private String name;
}
