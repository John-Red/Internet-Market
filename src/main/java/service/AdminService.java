package service;

import entities.Items;
import entities.Users;
import java.util.List;
import repositories.UsersRepository;
import repositories.impl.ItemsRepositoryImpl;
import repositories.impl.UsersRepositoryImpl;

public enum AdminService  {
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

  public void changeStateAndRole (Long userId,String role, Boolean state){
    UsersRepositoryImpl.INSTANCE.changeActiveState(userId, state);
    UsersRepositoryImpl.INSTANCE.changeRole(userId, role);
  }

}
