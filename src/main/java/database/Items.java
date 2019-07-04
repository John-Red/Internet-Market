package database;

import lombok.Data;

@Data
public class Items {
  private int item_id;
  private String item_name;
  private int category_id;
  private int price;
  private int available;
}
