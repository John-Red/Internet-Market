package repositories;

import entities.Users;
import java.util.List;

public interface UsersRepository {
  List<Users> get();

  void insert(String login, String password, String role, boolean active);

  boolean delete(Long id);

}
