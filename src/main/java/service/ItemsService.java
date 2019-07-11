package service;

import entities.Items;
import java.util.List;
import repositories.impl.ItemsRepositoryImpl;

public enum ItemsService {
  INSTANCE;

  public void insert(String name, long categoryId, int price, int available) {
    ItemsRepositoryImpl.INSTANCE.insert(name, categoryId, price, available);
  }

  public List<Items> get() {
    return ItemsRepositoryImpl.INSTANCE.get();
  }

  public void delete(Long id) {
    ItemsRepositoryImpl.INSTANCE.delete(id);
  }
}
