package repositories.impl;

import entities.Categories;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import utils.DatabaseConnection;

public enum CategoriesRepositoryImpl {
  INSTANCE;

  List<Categories> result;

  public List<Categories> get() {
    result =
        DatabaseConnection.INSTANCE
            .getConnection()
            .query(
                "SELECT * FROM categories",
                new RowMapper<Categories>() {
                  public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return Categories.builder()
                        .categoryId(rs.getLong("category_id"))
                        .name(rs.getString("name"))
                        .build();
                  }
                });
    return result;
  }

  public List<Categories> getCategory(String categoryName) {
    result =
        DatabaseConnection.INSTANCE
            .getConnection()
            .query(
                "SELECT * FROM categories WHERE name = ?",
                new RowMapper<Categories>() {
                  public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return Categories.builder()
                        .categoryId(rs.getLong("category_id"))
                        .name(rs.getString("name"))
                        .build();
                  }
                },
                categoryName);
    return result;
  }

  public void insert(String name) {
    DatabaseConnection.INSTANCE
        .getConnection()
        .update("INSERT INTO categories (name) VALUES (?);", name);
  }
}
