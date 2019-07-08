package repositories;

import entities.Items;

import java.util.List;

public interface ItemRepository extends CommonRepository {
    List<Items> get ();
    boolean delete(Integer id);
}
