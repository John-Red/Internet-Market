package service;

import entities.Items;
import lombok.extern.log4j.Log4j;
import repositories.impl.ItemRepositoryImpl;

import java.util.List;
import utils.exeptions.DataDoesNotExist;

@Log4j
public enum ItemsService {
  INSTANCE;

  public void insert(String name, long categoryId, int price, int available) {

    ItemRepositoryImpl.INSTANCE.insert(name, categoryId, price, available);
  }

  public List<Items> get() {
    return ItemRepositoryImpl.INSTANCE.get();
  }

  public void delete(Long id) throws DataDoesNotExist {
    if (ItemRepositoryImpl.INSTANCE.isExist(id)) {
      ItemRepositoryImpl.INSTANCE.delete(id);
    } else {
      throw new DataDoesNotExist();
    }
  }
}
