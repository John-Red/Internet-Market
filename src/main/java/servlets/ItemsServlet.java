package servlets;

import entities.Items;
import org.apache.catalina.connector.Connector;
import repositories.ItemRepository;
import repositories.impl.ItemRepositoryImpl;
import service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ItemsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<Items> list = ItemService.INSTANCE.get();
    request.setAttribute("itemsList", list);

    request.getRequestDispatcher("/items.jsp").forward(request, response);
  }
}
