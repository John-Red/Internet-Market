package service;

import entities.Items;
import repositories.ItemRepository;
import repositories.impl.ItemRepositoryImpl;

import java.util.List;

public enum ItemsService {
  INSTANCE;

  public void insert(String name, long categoryId, int price, int available) {
    ItemRepositoryImpl.INSTANCE.insert(name, categoryId, price, available);
  }

  public List<Items> get() {
    return ItemRepositoryImpl.INSTANCE.get();
  }

  public void delete(Long id) {
    ItemRepositoryImpl.INSTANCE.delete(id);
  }
}
