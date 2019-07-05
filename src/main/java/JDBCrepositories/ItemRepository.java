package JDBCrepositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ItemRepository {


    public static void main(String args[]) {

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.postgresql.Driver.class);
        dataSource.setUrl("jdbc:postgresql://rogue.db.elephantsql.com:5432/jgmweyay");
        dataSource.setUsername("jgmweyay");
        dataSource.setPassword("dh4gKvTLWAmMZKYQ5JSt_yCUMgxWI9bL");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


        System.out.println("Querying for items");
        List<TestItem> results = jdbcTemplate.query(
                "SELECT * FROM items", new Object[]{},
                new RowMapper<TestItem>() {
                    public TestItem mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        TestItem.builder().category_id(rs.getLong("item_id")).build()
                        return new TestItem(rs.getLong("item_id"), rs.getString("name"),
                                rs.getLong("category_id"), rs.getInt("price"), rs.getInt("available"));
                    }
                });

        for (TestItem item : results) {
            System.out.println(item);
        }
    }
}

