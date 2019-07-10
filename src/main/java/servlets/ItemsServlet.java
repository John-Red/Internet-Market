package servlets;

import entities.Items;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ItemsService;

public class ItemsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<Items> list = ItemsService.INSTANCE.get();
    request.setAttribute("itemsList", list);

    request.getRequestDispatcher("/items.jsp").forward(request, response);
  }
}
