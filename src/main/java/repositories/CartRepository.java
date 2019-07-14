package repositories;

import entities.Cart;
import java.util.List;

public interface CartRepository {

  List<Cart> get();

  void insert(Long userId, int itemId, int quantity);

  boolean delete(Long id);
}
