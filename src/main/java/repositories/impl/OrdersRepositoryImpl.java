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
    result =
        statement.query(
            "SELECT * FROM orders",
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

  public void insert(Long userId) {
    String sql = "INSERT INTO orders (user_id) VALUES (?);";
    statement.update(sql, userId);
  }

  public boolean delete(Integer order_id) {
    String sql = "DELETE FROM orders WHERE order_id = ?";
    return statement.update(sql, order_id) == 1;
  }

  public List<Orders> getUsersOrder(Long userId) {
    result =
        statement.query(
            "SELECT * FROM orders WHERE active = true AND user_id=?",
            new RowMapper<Orders>() {
              public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Orders.builder()
                    .orderId(rs.getLong("order_id"))
                    .userId(rs.getLong("user_id"))
                    .active(rs.getBoolean("active"))
                    .build();
              }
            },
            userId);
    return result;
  }

  public Long getOrderIdForCurrentUser(Long userId) {
    String sql = "SELECT order_id FROM orders WHERE user_id = ? AND active = true";
    return statement.queryForObject(sql, new Object[] {userId}, Long.class);
  }

  public void setOrderToFalse(Long orderId) {
    String sql = "UPDATE orders SET active = false WHERE order_id = ?";
    statement.update(sql, orderId);
  }
}
