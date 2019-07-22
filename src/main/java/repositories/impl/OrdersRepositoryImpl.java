package repositories.impl;

import entities.Orders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import repositories.OrdersRepository;
import utils.DatabaseConnection;

public enum OrdersRepositoryImpl implements OrdersRepository {
  INSTANCE;
  List<Orders> result;
  JdbcTemplate statement = DatabaseConnection.INSTANCE.getStatement();

  public List<Orders> get() {
    result = statement.query("SELECT * FROM orders",
        new RowMapper<Orders>() {
          public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Orders.builder()
                .orderId(rs.getLong("order_id"))
                .userId(rs.getLong("user_id"))
                .active(rs.getBoolean("active"))
                .build();
          }
        });
    return result;
  }

  public void insert(Integer userId) {
    String sql = "INSERT INTO orders (user_id) VALUES (?);";
    statement.update(sql, userId);
  }

  public boolean delete(Integer order_id) {
    String sql = "DELETE FROM orders WHERE order_id = ?";
    return statement.update(sql, order_id) == 1;
  }

  public List<Orders> getUsersOrder() {
    result = statement.query("SELECT * FROM orders WHERE active = true AND user_id=1",
        new RowMapper<Orders>() {
          public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Orders.builder()
                .orderId(rs.getLong("order_id"))
                .userId(rs.getLong("user_id"))
                .active(rs.getBoolean("active"))
                .build();
          }
        });
    return result;
  }
}
