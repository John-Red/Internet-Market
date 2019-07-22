package utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public enum DatabaseConnection {
  INSTANCE;

  private JdbcTemplate jdbcTemplate;

  DatabaseConnection() {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    dataSource.setDriverClass(org.postgresql.Driver.class);
    dataSource.setUrl(ServerAppConfig.getInstance().getDatabaseUrl());
    dataSource.setUsername(ServerAppConfig.getInstance().getDatabaseUsername());
    dataSource.setPassword(ServerAppConfig.getInstance().getDatabasePassword());
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public JdbcTemplate getStatement() {
    return jdbcTemplate;
  }
}
