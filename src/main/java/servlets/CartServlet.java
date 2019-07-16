package servlets;

import entities.Cart;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.impl.CartRepositoryImpl;
import service.CartService;

public class CartServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      List<Cart> list = CartService.INSTANCE.get();

      request.setAttribute("cartList", list);

      request.getRequestDispatcher("/cart.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("delete");
    Long id = Long.parseLong(name);
    CartRepositoryImpl.INSTANCE.delete(id);

    resp.sendRedirect("/cart");
  }
}
