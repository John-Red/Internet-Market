package repositories.impl;

import entities.Cart;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.springframework.jdbc.core.RowMapper;
import repositories.CartRepository;
import utils.DatabaseConnection;

@Log4j
public enum CartRepositoryImpl implements CartRepository {
  INSTANCE;

  public List<Cart> get() {
    return DatabaseConnection.INSTANCE
        .getConnection()
        .query(
            "SELECT items.image, items.name, items.price, item_orders.quantity, item_orders.item_order_id FROM users\n"
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
                    .itemOrderId(rs.getInt("item_order_id"))
                    .build();
              }
            });
  }

  public boolean delete(Long item_order_id) {
    String sql = "DELETE FROM item_orders WHERE item_order_id = ?";
    return DatabaseConnection.INSTANCE.getConnection().update(sql, item_order_id) == 1;
  }
}
