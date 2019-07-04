package database;

import lombok.Data;

@Data
public class Items {
  private Long itemId;
  private String name;
  private Long categoryId;
  private Integer price;
  private Integer available;
}
