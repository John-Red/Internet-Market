package servlets;

import entities.Items;
import entities.Users;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AdminService;
import service.ItemsService;

public class AdminServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<Users> listOfUsers = AdminService.INSTANCE.getAllUsers();
    request.setAttribute("usersList", listOfUsers);

    List<Items> listOfItems = AdminService.INSTANCE.getAllItems();
    request.setAttribute("itemsList", listOfItems);
    request.getRequestDispatcher("/admin.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    //delete item from db
    String delete = req.getParameter("delete");
    if (delete != null) {
      try {
        ItemsService.INSTANCE.delete(Long.valueOf(delete));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    String state = req.getParameter("getState");
    String userId = req.getParameter("userId");
    String role = req.getParameter("getRole");
    if (userId != null) {
      AdminService.INSTANCE.changeStateAndRole(Long.valueOf(userId), role, Boolean.valueOf(state));
    }
    resp.sendRedirect(req.getContextPath() + "/admin");
  }
}
