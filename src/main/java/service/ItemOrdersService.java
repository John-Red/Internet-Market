package service;

import entities.ItemOrders;
import java.util.List;
import repositories.impl.ItemOrderRepositoryImpl;

public enum ItemOrdersService {
  INSTANCE;

  public List<ItemOrders> get() {
    return ItemOrderRepositoryImpl.INSTANCE.get();
  }

  public void insert(Long itemId, int orderId, int quantity){

    ItemOrderRepositoryImpl.INSTANCE.insert(itemId, orderId, quantity);
  }

  public boolean delete(Long id)  {
    return ItemOrderRepositoryImpl.INSTANCE.delete(id);
  }
}
