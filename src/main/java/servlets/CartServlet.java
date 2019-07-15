package servlets;

import entities.Cart;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CartService;

public class CartServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      List<Cart> list = CartService.INSTANCE.get();

      request.setAttribute("cartList", list);

      request.getRequestDispatcher("/cart.jsp").forward(request, response);
  }
}
