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

    final HttpSession session = request.getSession();
    //check logged or not
    Cart.currentUserId = UsersRepositoryImpl.INSTANCE.getCurrentUserId(session.getAttribute("login"));
    List<Cart> list = CartService.INSTANCE.get();
    request.setAttribute("cartList", list);
    request.setAttribute("userId", Cart.currentUserId);
    request.setAttribute("Subtotal", CartService.INSTANCE.getSubtotalPrice());
    request.setAttribute("CartQuantity", CartService.INSTANCE.getCartQuantity());
    request.getRequestDispatcher("/cart.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String deleteParameter = request.getParameter("delete");
    if (deleteParameter != null) {
      Long itemOrderId = Long.parseLong(deleteParameter);
      CartService.INSTANCE.delete(itemOrderId);
    }

    String incrementParameter = request.getParameter("incrementQuantity");
    if (incrementParameter != null) {
      Long itemOrderId = Long.parseLong(incrementParameter);
      CartService.INSTANCE.incrementQuantity(itemOrderId);
    }

    String decrementParameter = request.getParameter("decrementQuantity");
    if (decrementParameter != null) {
      Long itemOrderId = Long.parseLong(decrementParameter);
      CartService.INSTANCE.decrementQuantity(itemOrderId);
    }

    String buyParameter = request.getParameter("proceedToCheckout");
    if (buyParameter != null){
      Long userId = Long.parseLong(buyParameter);
      if (CartService.INSTANCE.getSubtotalPrice() <= UsersService.INSTANCE.getUserBalance(userId)){
        UsersService.INSTANCE.updateUserBalance(userId);
      } else {
        String someMessage = "Error !";
        PrintWriter out = response.getWriter();
        out.print("<html><head>");
        out.print("<script type=\"text/javascript\">alert(" + someMessage + ");</script>");
        out.print("</head><body></body></html>");
      }
    }
    response.sendRedirect("/cart");
  }
}
