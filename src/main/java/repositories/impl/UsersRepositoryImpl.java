package repositories.impl;

import entities.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import repositories.UsersRepository;
import utils.DatabaseConnection;

public enum UsersRepositoryImpl {
  INSTANCE;

  JdbcTemplate statement = DatabaseConnection.INSTANCE.getConnection();

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
    statement.update(
            "INSERT INTO items (name, category_id, price, available) VALUES (?, ?, ?, ?);",
            login,
            password,
            role,
            active);
  }

  public boolean delete(Long id) {
    String sql = "DELETE FROM items WHERE user_id = ?";
    return statement.update(sql, id) == 1;
  }

  public void changeActiveState (Long userId, Boolean state){
    String sql = "UPDATE users SET active = ? WHERE user_id = ?;";
    statement.update(sql,state, userId);
  }

  public void changeRole (Long userId, String role){
    String sql = "UPDATE users SET role = ? WHERE user_id = ?;";
    statement.update(sql,role, userId);
  }


  public int compare(Users o1, Users o2) {
    return o1.getUserId().intValue() - o2.getUserId().intValue();
  }
}

