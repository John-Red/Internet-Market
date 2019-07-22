package servlets;

import entities.Categories;
import entities.Items;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.impl.CartRepositoryImpl;
import repositories.impl.CategoriesRepositoryImpl;
import repositories.impl.UsersRepositoryImpl;
import service.ItemOrdersService;
import service.ItemsService;

public class ItemsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String selectedCategory = request.getParameter("category");
    List<Items> itemsList = ItemsService.INSTANCE.get(selectedCategory);
    List<Categories> categories = CategoriesRepositoryImpl.INSTANCE.get();
    request.setAttribute("itemsList", itemsList);
    request.setAttribute("categoriesList", categories);
    request.setAttribute("CartQuantity", CartRepositoryImpl.INSTANCE.getSumCartQuantity());
    request.getRequestDispatcher("/items.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    final HttpSession session = req.getSession();
    Long userId = UsersRepositoryImpl.INSTANCE.getCurrentUserId(session.getAttribute("login"));
    String name = req.getParameter("addInCart");
    Long itemId = Long.parseLong(name);
    ItemOrdersService.INSTANCE.insert(itemId,userId);
    resp.sendRedirect("/items");
  }
}
