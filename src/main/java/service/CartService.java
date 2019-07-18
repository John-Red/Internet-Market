package service;

import entities.Cart;
import java.util.List;
import repositories.impl.CartRepositoryImpl;
import repositories.impl.ItemOrderRepositoryImpl;

public enum CartService {
  INSTANCE;

  public List<Cart> get() {
    List<Cart> cartList = CartRepositoryImpl.INSTANCE.get();
    for (Cart c  : cartList) {
        c.setTotalPrice(c.getItemsPrice() * c.getItemOrdersQuantity());
    }
    return cartList;
  }

  public Integer getSubtotalPrice() {
    List<Cart> cartList = get();
    Integer subTotalPrice = 0;
    for (Cart c  : cartList) {
      subTotalPrice += c.getTotalPrice();
    }
    return subTotalPrice;
  }


  public boolean delete(Long item_order_id) {
    return CartRepositoryImpl.INSTANCE.delete(item_order_id);
  }

  public Integer getCartQuantity() {
    return CartRepositoryImpl.INSTANCE.getSumCartQuantity();
  }

  public void incrementQuantity(Long item_order_id) {
    if (CartRepositoryImpl.INSTANCE.availablity(
            ItemOrderRepositoryImpl.INSTANCE.getItemId(item_order_id))
        > CartRepositoryImpl.INSTANCE.getCartQuantityForItem(item_order_id)) {
      CartRepositoryImpl.INSTANCE.incrementQuantity(item_order_id);
    }
  }

  public void decrementQuantity(Long item_order_id) {
    if (CartRepositoryImpl.INSTANCE.getCartQuantityForItem(item_order_id) > 1) {
      CartRepositoryImpl.INSTANCE.decrementQuantity(item_order_id);
    }
  }
}
