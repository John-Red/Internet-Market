package repositories;

import entities.Items;
import java.util.List;

public interface ItemsRepository {

  List<Items> get();

  void insert(String name, long categoryId, int price, int available, String image);

  boolean delete(Long id);
}
