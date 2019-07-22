package service;

import lombok.extern.log4j.Log4j;
import repositories.impl.CartRepositoryImpl;
import repositories.impl.OrdersRepositoryImpl;
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
      UsersRepositoryImpl.INSTANCE.insert(login, password, "user", true);
    } else {
      throw new InvalidLoginOrPassword();
    }
  }

//  public Integer getCurrentUserId(String login){
//    return UsersRepositoryImpl.INSTANCE.getCurrentUserId(login);
//  }

  public Integer getUserBalance(Long userId) {
    return UsersRepositoryImpl.INSTANCE.getUserBalance(userId);
  }

  public void updateUserBalance(Long userId) {
    Integer balance = UsersRepositoryImpl.INSTANCE.getUserBalance(userId) - CartService.INSTANCE.getSubtotalPrice();
    UsersRepositoryImpl.INSTANCE.updateUserBalance(userId, balance);
  }

  public boolean isUserExist(String login){
    return UsersRepositoryImpl.INSTANCE.isUserExist(login);
  }

  public String getRoleByLogin (String login){
    return UsersRepositoryImpl.INSTANCE.getRole(login);
  }

  public boolean validatePassword (String password, String login){
    return UsersRepositoryImpl.INSTANCE.validatePassword(password, login);
  }

  public boolean isUserActive(String login){
    return UsersRepositoryImpl.INSTANCE.isUserActive(login);
  }


}
