package repositories.impl;

import entities.Cart;
import entities.Orders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import repositories.CartRepository;
import utils.DatabaseConnection;

public enum CartRepositoryImpl implements CartRepository {
  INSTANCE;

  public List<Cart> get() {
    return DatabaseConnection.INSTANCE
        .getConnection()
        .query(
            "SELECT items.image, items.name, items.price, item_orders.quantity FROM users\n"
                + "JOIN orders on users.user_id = orders.user_id\n"
                + "JOIN item_orders on orders.order_id = item_orders.order_id\n"
                + "join items on items.item_id = item_orders.item_id;",
            new RowMapper<Cart>() {
              public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Cart.builder()
                    .itemsImage(rs.getString("image"))
                    .itemsName(rs.getString("name"))
                    .itemsPrice(rs.getInt("price"))
                    .itemOrdersQuantity(rs.getInt("quantity"))
                    .build();
              }
            });
  }
}
