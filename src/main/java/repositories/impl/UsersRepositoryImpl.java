package repositories.impl;

import entities.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import utils.DatabaseConnection;

public enum UsersRepositoryImpl {
  INSTANCE;

  public List<Users> get() {
    List<Users> result =
        DatabaseConnection.INSTANCE
            .getConnection()
            .query(
                "SELECT * FROM users",
                new Object[]{},
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
    return result;
  }

  public void insert(String login, String password, String role, boolean active) {
    DatabaseConnection.INSTANCE
        .getConnection()
        .update(
            "INSERT INTO users (login, password, role, active) VALUES (?, ?, ?, ?);",
            login,
            password,
            role,
            active);
  }

  public boolean delete(Integer user_id) {
    String sql = "DELETE FROM users WHERE user_id = ?";
    return DatabaseConnection.INSTANCE.getConnection().update(sql, user_id) == 1;
  }
}
