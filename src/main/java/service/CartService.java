package service;

import entities.Cart;
import java.util.List;
import lombok.extern.log4j.Log4j;
import repositories.OrdersRepository;
import repositories.impl.CartRepositoryImpl;
import repositories.impl.ItemOrderRepositoryImpl;
import repositories.impl.ItemsRepositoryImpl;
import repositories.impl.OrdersRepositoryImpl;
import repositories.impl.UsersRepositoryImpl;

@Log4j
public enum CartService {
  INSTANCE;

  public List<Cart> get(Long userId) {
    return CartRepositoryImpl.INSTANCE.get(Cart.currentUserId);
  }

  public Integer getSubtotalPrice() {
    return get(Cart.currentUserId).stream().mapToInt(cart -> cart.getTotalPrice()).sum();
  }

  public boolean delete(Long item_order_id) {
    return CartRepositoryImpl.INSTANCE.delete(item_order_id);
  }

  public Integer getCartQuantity() {
    if (CartRepositoryImpl.INSTANCE.getSumCartQuantity() == null) {
      return 0;
    } else {
      return CartRepositoryImpl.INSTANCE.getSumCartQuantity();
    }
  }

  public void incrementQuantity(Long item_order_id) {
    if (CartRepositoryImpl.INSTANCE.availablityOfItem(
            ItemOrderRepositoryImpl.INSTANCE.getItemId(item_order_id))
        > CartRepositoryImpl.INSTANCE.getCartQuantityForItem(item_order_id)) {
      CartRepositoryImpl.INSTANCE.incrementQuantity(item_order_id);
    } else {
      log.info("No more items available");
    }
  }

  public void decrementQuantity(Long item_order_id) {
    if (CartRepositoryImpl.INSTANCE.getCartQuantityForItem(item_order_id) > 1) {
      CartRepositoryImpl.INSTANCE.decrementQuantity(item_order_id);
    } else {
      log.info("Item quantity can't be negative");
    }
  }

  public Long getOrderIdForCurrentUser(Long userId){
    return OrdersRepositoryImpl.INSTANCE.getOrderIdForCurrentUser(userId);
  }

  public void setOrderToFalse(Long userId){
    OrdersRepositoryImpl.INSTANCE.setOrderToFalse(getOrderIdForCurrentUser(userId));
  }

  public void reduceQtyOfAvailableItems (List<Cart> listOfCartItems) {
    for (Cart c : listOfCartItems) {
      ItemsRepositoryImpl.INSTANCE.reduceQtyOfAvailableItems(c.getItemId(), c.getItemOrdersQuantity());
    }


  }
}
