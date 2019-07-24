package repositories.impl;

import entities.Items;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import repositories.ItemsRepository;
import utils.DatabaseConnection;

@Log4j
public enum ItemsRepositoryImpl implements ItemsRepository {
  INSTANCE;

  List<Items> result;
  JdbcTemplate statement = DatabaseConnection.INSTANCE.getStatement();

  public List<Items> get() {
    result =
        statement.query(
            "SELECT * FROM items",
            new RowMapper<Items>() {
              public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Items.builder()
                    .itemId(rs.getLong("item_id"))
                    .name(rs.getString("name"))
                    .categoryId(rs.getLong("category_id"))
                    .price(rs.getInt("price"))
                    .available(rs.getInt("available"))
                    .image(rs.getString("image") != null ? rs.getString("image") : "default.jpg")
                    .build();
              }
            });
    return result;
  }

  public List<Items> getAllAvailable() {
    result =
        statement.query(
            "SELECT * FROM items WHERE available >0;",
            new RowMapper<Items>() {
              public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Items.builder()
                    .itemId(rs.getLong("item_id"))
                    .name(rs.getString("name"))
                    .categoryId(rs.getLong("category_id"))
                    .price(rs.getInt("price"))
                    .available(rs.getInt("available"))
                    .image(rs.getString("image") != null ? rs.getString("image") : "default.jpg")
                    .build();
              }
            });
    return result;
  }

  public List<Items> get(Long itemId) {
    result =
        statement.query(
            "SELECT * FROM items WHERE item_id = ?",
            new RowMapper<Items>() {
              public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Items.builder()
                    .itemId(rs.getLong("item_id"))
                    .name(rs.getString("name"))
                    .categoryId(rs.getLong("category_id"))
                    .price(rs.getInt("price"))
                    .available(rs.getInt("available"))
                    .image(rs.getString("image") != null ? rs.getString("image") : "default.jpg")
                    .build();
              }
            },
            itemId);
    return result;
  }

  public List<Items> getByCategory(Long categoryId) {
    result =
        statement.query(
            "SELECT * FROM items WHERE category_id = ? AND available>0",
            new RowMapper<Items>() {
              public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Items.builder()
                    .itemId(rs.getLong("item_id"))
                    .name(rs.getString("name"))
                    .categoryId(rs.getLong("category_id"))
                    .price(rs.getInt("price"))
                    .available(rs.getInt("available"))
                    .image(rs.getString("image") != null ? rs.getString("image") : "default.jpg")
                    .build();
              }
            },
            categoryId);
    return result;
  }

  public void insert(String name, long categoryId, int price, int available, String image) {
    String sql =
        "INSERT INTO items (name, category_id, price, available, image) VALUES (?, ?, ?, ?,?);";
    statement.update(sql, name, categoryId, price, available, image);
  }

  public void updateImage(int id, String image) {
    String sql = "UPDATE items SET image = ? WHERE item_id = ?";
    statement.update(sql, image, id);
  }

  public boolean delete(Long id) {
    String sql = "DELETE FROM items WHERE item_id = ?";
    return statement.update(sql, id) == 1;
  }

  public boolean isExist(Long id) {
    String sql = "SELECT COUNT(*) FROM items WHERE item_id = ?";
    boolean exists = false;
    try {
      exists = statement.queryForObject(sql, new Object[] {id}, Integer.class) > 0;
    } catch (Exception e) {
      log.error(e);
    } finally {
      return exists;
    }
  }

  public boolean isExist(String name) {
    String sql = "SELECT COUNT(*) FROM items WHERE name = ?";
    boolean exists = false;
    try {
      exists = statement.queryForObject(sql, new Object[] {name}, Integer.class) > 0;
    } catch (Exception e) {
      log.error(e);
    } finally {
      return exists;
    }
  }

  public void setQtyOfAvailableItems(Integer available, Long itemId) {
    String sql = "UPDATE items SET available = ? WHERE item_id = ?";
    statement.update(sql, available, itemId);
  }
}
