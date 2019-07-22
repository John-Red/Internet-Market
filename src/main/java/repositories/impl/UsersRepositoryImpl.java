package repositories.impl;

import entities.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.DatabaseConnection;

@Log4j
public enum UsersRepositoryImpl {
  INSTANCE;

  JdbcTemplate statement = DatabaseConnection.INSTANCE.getStatement();

  public List<Users> get() {
    return statement.query(
        "SELECT * FROM users order by login",
        new RowMapper<Users>() {
          public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Users.builder()
                .userId(rs.getLong("user_id"))
                .login(rs.getString("login"))
                .password(rs.getString("password"))
                .role(rs.getString("role"))
                .active(rs.getBoolean("active"))
                .build();
          }
        });
  }

  public void insert(String login, String password, String role, boolean active) {
    String sql = "INSERT INTO users (login, password, role, active) VALUES (?, ?, ?, ?);";
    statement.update(sql, login, password, role, active);
  }

  public boolean delete(Long id) {
    String sql = "DELETE FROM items WHERE user_id = ?";
    return statement.update(sql, id) == 1;
  }

  public void changeActiveState(Long userId, Boolean state) {
    String sql = "UPDATE users SET active = ? WHERE user_id = ?;";
    statement.update(sql, state, userId);
  }

  public void changeRole(Long userId, String role) {
    String sql = "UPDATE users SET role = ? WHERE user_id = ?;";
    statement.update(sql, role, userId);
  }

  public String getRole(String login) {
    String sql = "SELECT role FROM users WHERE login = ?;";
    return statement.queryForObject(sql, new Object[]{login}, String.class);
  }

  public boolean isUserExist(String login) {
    String sql = "SELECT COUNT(*) FROM users WHERE login = ?";
    boolean exists = false;
    try {
      exists = statement.queryForObject(sql, new Object[]{login}, Integer.class) > 0;
    } catch (Exception e) {
      log.error(e);
    } finally {
      return exists;
    }
  }

  public boolean validatePassword(String password, String login) {
    String sql = "SELECT password FROM users WHERE login = ?;";
    String passwordFromDB = statement.queryForObject(sql, new Object[]{login}, String.class);
    return password.equals(passwordFromDB);
  }


  public boolean loginAlreadyExists(String login) {
    String sql = "SELECT COUNT(*) FROM users WHERE login = ?";
    boolean exists = true;
    try {
      exists = statement.queryForObject(sql, new Object[]{login}, Integer.class) > 0;
    } catch (Exception e) {
      log.error(e);
    } finally {
      return exists;
    }
  }
  public Long getCurrentUserId(Object login){
    String sql = "SELECT user_id FROM users WHERE login = ?";
    return statement.queryForObject(sql, new Object[] {login}, Long.class);
  }
}
