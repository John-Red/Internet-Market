package service;

import entities.Items;
import entities.Users;
import java.util.List;
import repositories.impl.ItemsRepositoryImpl;
import repositories.impl.UsersRepositoryImpl;

public enum AdminService {
  INSTANCE;

  public List<Users> getAllUsers() {
    return UsersRepositoryImpl.INSTANCE.get();
  }

  public List<Items> getAllItems() {
    return ItemsRepositoryImpl.INSTANCE.get();
  }

  public void delete(Long id) {
    ItemsRepositoryImpl.INSTANCE.delete(id);
  }

}
