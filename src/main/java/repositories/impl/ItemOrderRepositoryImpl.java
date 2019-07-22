package repositories.impl;

import entities.ItemOrders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import repositories.ItemOrdersRepository;
import utils.DatabaseConnection;

@Log4j
public enum ItemOrderRepositoryImpl implements ItemOrdersRepository {
  INSTANCE;

  List<ItemOrders> result;
  JdbcTemplate statement = DatabaseConnection.INSTANCE.getStatement();

  public List<ItemOrders> get() {
    result = statement.query("SELECT * FROM item_orders",
        new RowMapper<ItemOrders>() {
          public ItemOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
            return ItemOrders.builder()
                .itemOrderId(rs.getLong("item_order_id"))
                .itemId(rs.getLong("item_id"))
                .orderId(rs.getLong("order_id"))
                .quantity(rs.getInt("quantity"))
                .build();
          }
        });
    return result;
  }

  public List<ItemOrders> getOrder(Long orderId) {
    result = statement.query(
        "SELECT * FROM item_orders WHERE order_id = ?",
        new RowMapper<ItemOrders>() {
          public ItemOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
            return ItemOrders.builder()
                .itemOrderId(rs.getLong("item_order_id"))
                .itemId(rs.getLong("item_id"))
                .orderId(rs.getLong("order_id"))
                .quantity(rs.getInt("quantity"))
                .build();
          }
        },
        orderId);
    return result;
  }

  public Long getItemId(Long item_order_id) {
    String sql = "SELECT item_id FROM item_orders WHERE item_order_id = ?";
    try {
      return statement.queryForObject(sql, new Object[]{item_order_id}, Long.class);
    } catch (DataAccessException e) {
      log.error("DataAccessException", e);
      return 0L;
    }
  }

  public void insert(Long itemId, Long orderId, int quantity) {
    String sql = "INSERT INTO item_orders (item_id, order_id, quantity) VALUES (?, ?, ?);";
    statement.update(sql, itemId, orderId, quantity);
  }

  public void set(int quantity, Long itemId, Long orderId) {
    String sql = "UPDATE item_orders SET quantity = ? WHERE item_id = ? AND order_id = ?;";
    statement.update(sql, quantity, itemId, orderId);
  }

  public boolean delete(Long id) {
    String sql = "DELETE FROM item_orders WHERE item_order_id = ?";
    return statement.update(sql, id) == 1;
  }

  public boolean deleteByItemId(Long id) {
    String sql = "DELETE FROM item_orders WHERE item_id = ?";
    return statement.update(sql, id) == 1;
  }
}
