package repositories.impl;

import entities.Cart;
import entities.Items;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import repositories.CartRepository;
import utils.DatabaseConnection;

public enum CartRepositoryImpl implements CartRepository {
  INSTANCE;

  List<Cart> result;

  public List<Cart> get() {
    result =
        DatabaseConnection.INSTANCE
            .getConnection()
            .query(
                "SELECT * FROM cart",
                new RowMapper<Cart>() {
                  public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return Cart.builder()
                        .id(rs.getLong("id"))
                        .userId(rs.getLong("user_id"))
                        .itemId(rs.getLong("item_id"))
                        .quantity(rs.getInt("quantity"))
                        .build();
                  }
                });
    return result;
  }

  public void insert(Long userId, int itemId, int quantity) {
    DatabaseConnection.INSTANCE
        .getConnection()
        .update(
            "INSERT INTO cart (user_id, item_id, quantity) VALUES (?, ?, ?);",
            userId,
            itemId,
            quantity);
  }

  public boolean delete(Long id) {
    String sql = "DELETE FROM cart WHERE id = ?";
    return DatabaseConnection.INSTANCE.getConnection().update(sql, id) == 1;
  }
}
