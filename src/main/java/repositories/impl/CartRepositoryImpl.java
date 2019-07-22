package repositories.impl;

import entities.Cart;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import repositories.CartRepository;
import utils.DatabaseConnection;

@Log4j
public enum CartRepositoryImpl implements CartRepository {
  INSTANCE;

  JdbcTemplate statement = DatabaseConnection.INSTANCE.getStatement();

  public List<Cart> get(Long userId) {
    return statement.query(
        "SELECT items.image, items.name, items.price, item_orders.quantity, item_orders.item_order_id, items.item_id FROM users\n"
            + "JOIN orders on users.user_id = orders.user_id\n"
            + "JOIN item_orders on orders.order_id = item_orders.order_id\n"
            + "join items on items.item_id = item_orders.item_id WHERE orders.active=true AND users.user_id=?;",
        new RowMapper<Cart>() {
          public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Cart.builder()
                .itemsImage(rs.getString("image"))
                .itemsName(rs.getString("name"))
                .itemsPrice(rs.getInt("price"))
                .itemOrdersQuantity(rs.getInt("quantity"))
                .itemOrderId(rs.getLong("item_order_id"))
                .itemId(rs.getLong("item_id"))
                .build();
          }
        }, userId);
  }

  public Integer availablityOfItem(Long item_id) {
    String sql = "SELECT available FROM items WHERE item_id = ?";
    try {
      return statement.queryForObject(sql, new Object[]{item_id}, Integer.class);
    } catch (DataAccessException e) {
      log.error("DataAccessException", e);
      return 0;
    }
  }

  public boolean delete(Long item_order_id) {
    String sql = "DELETE FROM item_orders WHERE item_order_id = ?";
    return statement.update(sql, item_order_id) == 1;
  }

  public Integer getSumCartQuantity() {
    String sql = "SELECT SUM(quantity) FROM item_orders";
    return statement.queryForObject(sql, Integer.class);
  }

  public Integer getCartQuantityForItem(Long item_order_id) {
    String sql = "SELECT quantity FROM item_orders WHERE item_order_id = ?";
    return statement.queryForObject(sql, new Object[]{item_order_id}, Integer.class);
  }

  public void incrementQuantity(Long item_order_id) {
    String sql = "UPDATE item_orders SET quantity = quantity + 1 WHERE item_order_id = ?";
    statement.update(sql, item_order_id);
  }

  public void decrementQuantity(Long item_order_id) {
    String sql = "UPDATE item_orders SET quantity = quantity - 1 WHERE item_order_id = ?";
    statement.update(sql, item_order_id);
  }
}
