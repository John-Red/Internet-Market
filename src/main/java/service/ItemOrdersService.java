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

  public void insert(Long itemId,Long userId) {

    List<Orders> listOrders = OrdersRepositoryImpl.INSTANCE.getUsersOrder(userId);
    if (listOrders.size() < 1) {
      OrdersRepositoryImpl.INSTANCE.insert(userId);
    }
      List<ItemOrders> listItemOrders =
          ItemOrderRepositoryImpl.INSTANCE.getOrder(listOrders. get(0).getOrderId());

      boolean idAlreadyExists = false;

      if (listItemOrders.size() > 0 && listOrders.size() > 0) {
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
        ItemOrderRepositoryImpl.INSTANCE.insert(
            itemId, OrdersRepositoryImpl.INSTANCE.getUsersOrder(userId).get(0).getOrderId(), 1);
      }
  }

  public boolean delete(Long orderId) {
    return ItemOrderRepositoryImpl.INSTANCE.delete(orderId);
  }

  //  public void cleanCartAfterPurchase(Long orderId) {
  //    cleanCartAfterPurchase(orderId);
  //  }
}

