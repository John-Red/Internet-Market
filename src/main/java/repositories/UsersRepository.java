package repositories;

import entities.Users;
import java.util.List;

public interface UsersRepository {

  List<Users> get();

  void insert(Integer userId, String login, String password, String role, boolean active);

  boolean delete(Integer userId);
}
