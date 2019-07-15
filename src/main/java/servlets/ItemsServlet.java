package servlets;

import com.sun.org.apache.xpath.internal.operations.Or;
import entities.Items;
import entities.Orders;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.impl.ItemOrderRepositoryImpl;
import repositories.impl.OrdersRepositoryImpl;
import service.ItemsService;

public class ItemsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<Items> list = ItemsService.INSTANCE.get();
     request.setAttribute("itemsList", list);

    request.getRequestDispatcher("/items.jsp").forward(request, response);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("addInCart");
    Long id = Long.parseLong(name);
    List<Orders> listOrders = OrdersRepositoryImpl.INSTANCE.getUsersOrder();
   // ItemOrderRepositoryImpl.INSTANCE.insert(id,);

      resp.sendRedirect("/items");
  }
}
