package servlets;

import entities.Cart;
import entities.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.CartRepository;
import repositories.impl.CartRepositoryImpl;
import repositories.impl.UsersRepositoryImpl;
import service.CartService;
import service.ItemOrdersService;
import service.UsersService;

public class CartServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    //check logged or not
    List<Cart> list = CartService.INSTANCE.get(Cart.currentUserId);
    int sumCartQuantity = 0;
    for (Cart c : list ) {sumCartQuantity += c.getItemOrdersQuantity();
    }
    request.setAttribute("cartList", list);
    request.setAttribute("userId", Cart.currentUserId);
    request.setAttribute("Subtotal", CartService.INSTANCE.getSubtotalPrice());
    request.setAttribute("CartQuantity", sumCartQuantity);
    request.getRequestDispatcher("/cart.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String deleteParameter = request.getParameter("delete");
    if (deleteParameter != null) {
      Long itemOrderId = Long.parseLong(deleteParameter);
      CartService.INSTANCE.delete(itemOrderId);
      response.sendRedirect("/cart");
    }

    String incrementParameter = request.getParameter("incrementQuantity");
    if (incrementParameter != null) {
      Long itemOrderId = Long.parseLong(incrementParameter);
      CartService.INSTANCE.incrementQuantity(itemOrderId);
      response.sendRedirect("/cart");
    }

    String decrementParameter = request.getParameter("decrementQuantity");
    if (decrementParameter != null) {
      Long itemOrderId = Long.parseLong(decrementParameter);
      CartService.INSTANCE.decrementQuantity(itemOrderId);
      response.sendRedirect("/cart");
    }

    String buyParameter = request.getParameter("proceedToCheckout");
    if (buyParameter != null){
      Long userId = Long.parseLong(buyParameter);
      if (CartService.INSTANCE.getSubtotalPrice() <= UsersService.INSTANCE.getUserBalance(userId)){
        UsersService.INSTANCE.updateUserBalance(userId);
        CartService.INSTANCE.setOrderToFalse(userId);
        CartService.INSTANCE.reduceQtyOfAvailableItems(CartService.INSTANCE.get(Cart.currentUserId));
        request.getRequestDispatcher("/you_made_a_purchase.jsp").forward(request, response);
      } else {
        request.getRequestDispatcher("/not_enough_money.jsp").forward(request, response);
      }
    }
  }
}
