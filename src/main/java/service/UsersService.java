package service;

import entities.UserRole;
import lombok.extern.log4j.Log4j;
import repositories.impl.UsersRepositoryImpl;
import utils.exeptions.InvalidLoginOrPassword;

@Log4j
public enum UsersService {
  INSTANCE;

  private boolean isLoginValid(String login) {
    return login.length() >= 4 && !UsersRepositoryImpl.INSTANCE.loginAlreadyExists(login);
  }

  private boolean isPasswordValid(String password) {
    return password.length() > 4 && password.length() < 255;
  }

  public void insert(String login, String password) throws InvalidLoginOrPassword {

    if (isPasswordValid(password) && isLoginValid(login)) {
      UsersRepositoryImpl.INSTANCE.insert(login, password,"user", true);
    } else {
      throw new InvalidLoginOrPassword();
    }
  }
}
