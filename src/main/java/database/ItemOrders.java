package database;

import lombok.Data;

@Data
public class ItemOrders {
    private int item_id;
    private int order_id;
    private int item_order_id;
    private int quantity;

}
