package repositories;

import entities.Orders;

import java.util.List;

public interface OrdersRepository {
  List<Orders> get();

  void insert(Integer userId);

  boolean delete(Integer orderId);
}
