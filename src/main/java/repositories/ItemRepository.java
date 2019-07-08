package repositories;

import entities.Items;

import java.util.List;

public interface ItemRepository extends CommonRepository {
    List<Items> get();

    void insert(String name, long categoryId, int price, int available);

    boolean delete(Integer id);
}
