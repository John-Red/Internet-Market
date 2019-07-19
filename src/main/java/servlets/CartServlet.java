package servlets;

import entities.Cart;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.CartRepository;
import repositories.impl.CartRepositoryImpl;
import service.CartService;

public class CartServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    List<Cart> list = CartService.INSTANCE.get();
    request.setAttribute("cartList", list);
    request.setAttribute("Subtotal", CartService.INSTANCE.getSubtotalPrice());
    request.setAttribute("CartQuantity", CartService.INSTANCE.getCartQuantity());

    request.getRequestDispatcher("/cart.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String deleteParameter = req.getParameter("delete");
    if (deleteParameter != null) {
      Long itemOrderId = Long.parseLong(deleteParameter);
      CartService.INSTANCE.delete(itemOrderId);
    }

    String incrementParameter = req.getParameter("incrementQuantity");
    if (incrementParameter != null) {
      Long itemOrderId = Long.parseLong(incrementParameter);
      CartService.INSTANCE.incrementQuantity(itemOrderId);
    }

    String decrementParameter = req.getParameter("decrementQuantity");
    if (decrementParameter != null) {
      Long itemOrderId = Long.parseLong(decrementParameter);
      CartService.INSTANCE.decrementQuantity(itemOrderId);
    }

    resp.sendRedirect("/cart");
  }
}
