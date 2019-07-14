package repositories;

import entities.ItemOrders;
import java.util.List;

public interface ItemOrdersRepository {

  List<ItemOrders> get();

  void insert(Long itemId, int orderId, int quantity);

  boolean delete(Long id);
}
