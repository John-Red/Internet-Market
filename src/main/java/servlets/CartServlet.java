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

    String name = req.getParameter("delete");
    if (name != null) {
      Long id = Long.parseLong(name);
      CartService.INSTANCE.delete(id);
    }

    String name1 = req.getParameter("incrementQuantity");
    if (name1 != null) {
      Long itemOrderId = Long.parseLong(name1);
      CartService.INSTANCE.incrementQuantity(itemOrderId);
    }

    String name2 = req.getParameter("decrementQuantity");
    if (name2 != null) {
      Long itemOrderId = Long.parseLong(name2);
      CartService.INSTANCE.decrementQuantity(itemOrderId);
    }

    resp.sendRedirect("/cart");
  }
}
