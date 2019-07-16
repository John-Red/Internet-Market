package service;

import entities.Cart;
import java.util.List;
import repositories.impl.CartRepositoryImpl;

public enum CartService {
  INSTANCE;

  public List<Cart> get() {
    return CartRepositoryImpl.INSTANCE.get();
  }
}
