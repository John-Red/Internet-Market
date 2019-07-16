package repositories.impl;

import entities.Items;
import lombok.extern.log4j.Log4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import repositories.ItemsRepository;
import utils.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Log4j
public enum ItemsRepositoryImpl implements ItemsRepository {
  INSTANCE;

  List<Items> result;

  public List<Items> get() {
    result =
        DatabaseConnection.INSTANCE.getConnection().query(
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
    DatabaseConnection.INSTANCE.getConnection().update(
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

  public boolean isExist(Long id) {
    String sql = "SELECT COUNT(*) FROM items WHERE item_id = ?";
    boolean exists = false;
    try {
      exists = DatabaseConnection.INSTANCE
                  .getConnection()
                  .queryForObject(sql, new Object[] {id}, Integer.class)
              > 0;
    } catch (DataAccessException e) {
      log.error(e);
    } finally {
      return exists;
    }
  }

  public boolean isExist(String name) {
    String sql = "SELECT COUNT(*) FROM items WHERE name = ?";
    boolean exists = false;
    try {
      exists =
          DatabaseConnection.INSTANCE
                  .getConnection()
                  .queryForObject(sql, new Object[] {name}, Integer.class)
              > 0;
    } catch (DataAccessException e) {
      log.error(e);
    } finally {
      return exists;
    }
  }
}
