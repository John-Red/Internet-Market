package servlets;

import entities.Cart;
import entities.Items;
import entities.Users;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j;
import service.AdminService;
import service.CartService;
import service.UsersService;

@Log4j
public class AdminServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<Users> listOfUsers = AdminService.INSTANCE.getAllUsers();
    req.setAttribute("usersList", listOfUsers);
    List<Items> listOfItems = AdminService.INSTANCE.getAllItems();
    List<Cart> list = CartService.INSTANCE.get(Cart.currentUserId);
    int sumCartQuantity = 0;
    for (Cart c : list) {
      sumCartQuantity += c.getItemOrdersQuantity();
    }
    req.setAttribute("itemsList", listOfItems);
    req.setAttribute("userBalance", UsersService.INSTANCE.getUserBalance(Cart.currentUserId));
    req.setAttribute("CartQuantity", sumCartQuantity);
    req.getRequestDispatcher("/admin.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    // delete item from db
    String delete = req.getParameter("delete");
    if (delete != null) {
      try {
        AdminService.INSTANCE.delete(Long.valueOf(delete));
      } catch (Exception e) {
        log.error(e);
      }
    }

    // change active state and user role
    String state = req.getParameter("getState");
    String userId = req.getParameter("userId");
    String role = req.getParameter("getRole");
    if (userId != null) {
      AdminService.INSTANCE.changeStateAndRole(Long.valueOf(userId), role, Boolean.valueOf(state));
    }

    // change balance
    String balance = req.getParameter("getBalance");
    if (balance != null) {
      AdminService.INSTANCE.updateUserBalance(Long.valueOf(userId), Integer.valueOf(balance));
    }
    resp.sendRedirect(req.getContextPath() + "/admin?lang=en");
  }
}
