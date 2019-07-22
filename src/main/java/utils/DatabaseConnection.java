package utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public enum DatabaseConnection {
  INSTANCE;

  private JdbcTemplate jdbcTemplate;

  DatabaseConnection() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl(ServerAppConfig.getInstance().getDatabaseUrl());
    dataSource.setUsername(ServerAppConfig.getInstance().getDatabaseUsername());
    dataSource.setPassword(ServerAppConfig.getInstance().getDatabasePassword());
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public JdbcTemplate getStatement() {
    return jdbcTemplate;
  }
}
