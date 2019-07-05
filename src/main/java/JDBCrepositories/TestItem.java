package JDBCrepositories;

import lombok.Builder;

@Builder
public class TestItem {
    long id;
    String name;
    long category_id;
    long price;
    int available;

    public TestItem(long id, String name, long category_id, long price, int available) {
        this.id = id;
        this.name = name;
        this.category_id = category_id;
        this.price = price;
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format(
                "Items: [id=%d, name =' %s', category_id = %s, price = %s, available = %s]",
                id, name, category_id, price, available);
    }


}

