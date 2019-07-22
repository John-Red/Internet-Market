package repositories;

import entities.Orders;
import java.util.List;

public interface OrdersRepository {

  List<Orders> get();

  void insert(Long userId);

  boolean delete(Integer orderId);
}
