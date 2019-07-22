package servlets;

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

@Log4j
public class AdminServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<Users> listOfUsers = AdminService.INSTANCE.getAllUsers();
    req.setAttribute("usersList", listOfUsers);
    List<Items> listOfItems = AdminService.INSTANCE.getAllItems();
    req.setAttribute("itemsList", listOfItems);
    req.setAttribute("CartQuantity", CartService.INSTANCE.getCartQuantity());
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
      AdminService.INSTANCE
          .changeStateAndRole(Long.valueOf(userId), role, Boolean.valueOf(state));
    }
    resp.sendRedirect(req.getContextPath() + "/admin");
  }

}
