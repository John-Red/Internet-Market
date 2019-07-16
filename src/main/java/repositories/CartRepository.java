package repositories;

import entities.Cart;
import java.util.List;

public interface CartRepository {

  List<Cart> get();

  boolean delete(Long itemOrderId);
}
