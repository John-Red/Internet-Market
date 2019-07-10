package repositories.impl;

import entities.Items;
import org.springframework.jdbc.core.RowMapper;
import repositories.ItemRepository;
import utils.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public enum ItemRepositoryImpl implements ItemRepository {
  INSTANCE;

  public List<Items> get() {
    List<Items> result =
        DatabaseConnection.INSTANCE
            .getConnection()
            .query(
                "SELECT * FROM items",
                new RowMapper<Items>() {
                  public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return Items.builder()
                        .itemId(rs.getLong("item_id"))
                        .name(rs.getString("name"))
                        .categoryId(rs.getLong("category_id"))
                        .price(rs.getInt("price"))
                        .available(rs.getInt("available"))
                        .build();
                  }
                });
    return result;
  }

  public void insert(String name, long categoryId, int price, int available) {
    DatabaseConnection.INSTANCE
        .getConnection()
        .update(
            "INSERT INTO items (name, category_id, price, available) VALUES (?, ?, ?, ?);",
            name,
            categoryId,
            price,
            available);
  }

  public boolean delete(Long id) {
    String sql = "DELETE FROM items WHERE item_id = ?";
    return DatabaseConnection.INSTANCE.getConnection().update(sql, id) == 1;
  }
}
