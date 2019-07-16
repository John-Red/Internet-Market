package service;

import entities.ItemOrders;
import entities.Orders;
import java.util.List;
import repositories.impl.ItemOrderRepositoryImpl;
import repositories.impl.OrdersRepositoryImpl;

public enum ItemOrdersService {
  INSTANCE;

  public List<ItemOrders> get() {
    return ItemOrderRepositoryImpl.INSTANCE.get();
  }

  public void insert(Long itemId) {
    List<Orders> listOrders = OrdersRepositoryImpl.INSTANCE.getUsersOrder();

    boolean idAlreadyExists = false;
    if (listOrders.size() > 1) {
      List<ItemOrders> listItemOrders =
          ItemOrderRepositoryImpl.INSTANCE.getOrder(listOrders.get(0).getOrderId());

      for (ItemOrders io : listItemOrders) {
        if (io.getItemId().equals(itemId)) {
          idAlreadyExists = true;
          if (io.getQuantity() < ItemsService.INSTANCE.get(itemId).get(0).getAvailable())
            ItemOrderRepositoryImpl.INSTANCE.set(
                io.getQuantity() + 1, itemId, listItemOrders.get(0).getOrderId());
        }
      }

      if (!idAlreadyExists) {
        ItemOrderRepositoryImpl.INSTANCE.insert(itemId, listItemOrders.get(0).getOrderId(), 1);
      }
    } else {
      OrdersRepositoryImpl.INSTANCE.insert(1);
      ItemOrderRepositoryImpl.INSTANCE.insert(
          itemId, OrdersRepositoryImpl.INSTANCE.getUsersOrder().get(0).getOrderId(), 1);
    }
  }

  public boolean delete(Long id) {
    return ItemOrderRepositoryImpl.INSTANCE.delete(id);
  }
}
