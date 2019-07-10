package service;

import entities.Items;
import repositories.ItemRepository;
import repositories.impl.ItemRepositoryImpl;

import java.util.List;

public enum ItemService {
  INSTANCE;

  private ItemRepository itemRepository = new ItemRepositoryImpl();

  public void insert(String name, long categoryId, int price, int available) {
     itemRepository.insert(name,categoryId,price,available);
  }

  public List<Items> get() {
    return itemRepository.get();
  }

  public void delete(Long id) {
    itemRepository.delete(id);
  }
}
