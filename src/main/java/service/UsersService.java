package service;

import lombok.extern.log4j.Log4j;
import repositories.impl.UsersRepositoryImpl;

@Log4j
public enum UsersService {
  INSTANCE;

  public boolean loginIsValid(String login) {
    if (login.length() > 4 && !UsersRepositoryImpl.INSTANCE.loginAlreadyExists(login)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean passwordIsValid(String password) {
    if (password.length() < 4) {
      return false;
    } else {
      return true;
    }
  }

  public void insert(String login, String password) {
    UsersRepositoryImpl.INSTANCE.insert(login, password, "User", true);
  }
}
