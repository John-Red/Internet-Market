package repositories;

import entities.Items;

import java.util.List;

public interface ItemRepository {
  List<Items> get();

  void insert(String name, long categoryId, int price, int available);

  boolean delete(Long id);
}
