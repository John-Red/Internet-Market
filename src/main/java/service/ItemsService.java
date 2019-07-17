package service;

import entities.Categories;
import entities.Items;
import java.util.List;
import repositories.impl.CategoriesRepositoryImpl;
import repositories.impl.ItemsRepositoryImpl;
import utils.exeptions.DataDoesNotExist;
import utils.exeptions.NameAlreadyExists;

public enum ItemsService {
  INSTANCE;

  public List<Items> get() {
    return ItemsRepositoryImpl.INSTANCE.get();
  }

  public List<Items> get(Long itemId) {
    return ItemsRepositoryImpl.INSTANCE.get(itemId);
  }

  public void insert(String name, long categoryId, int price, int available, String image)
      throws NameAlreadyExists {
    if (!ItemsRepositoryImpl.INSTANCE.isExist(name))
      ItemsRepositoryImpl.INSTANCE.insert(name, categoryId, price, available, image);
    else throw new NameAlreadyExists();
  }

  public void delete(Long id) throws DataDoesNotExist {
    if (ItemsRepositoryImpl.INSTANCE.isExist(id)) ItemsRepositoryImpl.INSTANCE.delete(id);
    else throw new DataDoesNotExist();
  }

  public List<Items> get(String categoryName){
    if (categoryName==null)
      return get();
    else {
      List<Categories> categories = CategoriesRepositoryImpl.INSTANCE.getCategory(categoryName);
      return (categories.size()>0) ? ItemsRepositoryImpl.INSTANCE.getByCategory(categories.get(0).getCategoryId()) : get();
    }
  }
}
