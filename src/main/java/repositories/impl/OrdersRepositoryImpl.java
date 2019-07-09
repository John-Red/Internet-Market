package repositories.impl;

import entities.Items;
import entities.Orders;
import org.springframework.jdbc.core.RowMapper;
import repositories.OrdersRepository;
import utils.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrdersRepositoryImpl implements OrdersRepository {
  public List<Orders> get() {
    List<Orders> result =
        DatabaseConnection.INSTANCE
            .getConnection()
            .query(
                "SELECT * FROM orders",
                new RowMapper<Orders>() {
                  public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return Orders.builder()
                        .orderId(rs.getLong("order_id"))
                        .userId(rs.getLong("user_id"))
                        .build();
                  }
                });
    return result;
  }

  public void insert(Integer userId) {
    DatabaseConnection.INSTANCE
        .getConnection()
        .update("INSERT INTO orders (user_id) VALUES (?);", userId);
  }

  public boolean delete(Integer order_id) {
    String sql = "DELETE FROM orders WHERE order_id = ?";
    return DatabaseConnection.INSTANCE.getConnection().update(sql, order_id) == 1;
  }
}
