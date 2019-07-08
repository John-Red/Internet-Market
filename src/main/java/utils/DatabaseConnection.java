package utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public enum DatabaseConnection {

    INSTANCE;

    private static final String URL = "jdbc:postgresql://rogue.db.elephantsql.com:5432/jgmweyay";
    private static final String USERNAME = "jgmweyay";
    private static final String PASSWORD = "dh4gKvTLWAmMZKYQ5JSt_yCUMgxWI9bL";
    private  JdbcTemplate jdbcTemplate;

    DatabaseConnection() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.postgresql.Driver.class);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public  JdbcTemplate getConnection() {
        return jdbcTemplate;
    }


}
