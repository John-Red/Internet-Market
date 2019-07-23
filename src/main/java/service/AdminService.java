package service;

import entities.Items;
import entities.Users;
import java.util.List;
import repositories.impl.ItemOrderRepositoryImpl;
import repositories.impl.ItemsRepositoryImpl;
import repositories.impl.UsersRepositoryImpl;
import utils.exeptions.DataDoesNotExist;

public enum AdminService {
  INSTANCE;

  public List<Users> getAllUsers() {
    return UsersRepositoryImpl.INSTANCE.get();
  }

  public List<Items> getAllItems() {
    return ItemsRepositoryImpl.INSTANCE.get();
  }

  public void delete(Long id) throws DataDoesNotExist {
    ItemOrderRepositoryImpl.INSTANCE.deleteByItemId(id);
    ItemsRepositoryImpl.INSTANCE.delete(id);
  }

  public void changeStateAndRole(Long userId, String role, Boolean state) {
    UsersRepositoryImpl.INSTANCE.changeActiveState(userId, state);
    UsersRepositoryImpl.INSTANCE.changeRole(userId, role);
  }

  public void updateUserBalance (Long userId, Integer balance){
    UsersRepositoryImpl.INSTANCE.updateUserBalance(userId, balance);
  }
}
