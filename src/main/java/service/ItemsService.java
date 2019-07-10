package service;

import entities.Items;
import repositories.impl.ItemRepositoryImpl;

import java.util.List;
import utils.exeptions.DataDoesNotExist;
import utils.exeptions.NameAlreadyExists;


public enum ItemsService {
  INSTANCE;

  public List<Items> get() {
    return ItemRepositoryImpl.INSTANCE.get();
  }

  public void insert(String name, long categoryId, int price, int available)
      throws NameAlreadyExists {
 if (!ItemRepositoryImpl.INSTANCE.isExist(name))
    ItemRepositoryImpl.INSTANCE.insert(name, categoryId, price, available);
 else
   throw new NameAlreadyExists();
  }

  public void delete(Long id) throws DataDoesNotExist {
    if (ItemRepositoryImpl.INSTANCE.isExist(id))
      ItemRepositoryImpl.INSTANCE.delete(id);
     else
      throw new DataDoesNotExist();
  }
}
