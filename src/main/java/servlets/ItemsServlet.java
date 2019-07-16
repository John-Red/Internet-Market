package servlets;

import com.sun.org.apache.xpath.internal.operations.Or;
import entities.Categories;
import entities.Items;
import entities.Orders;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Category;
import repositories.ItemsRepository;
import repositories.impl.CategoriesRepositoryImpl;
import repositories.impl.ItemOrderRepositoryImpl;
import repositories.impl.ItemsRepositoryImpl;
import repositories.impl.OrdersRepositoryImpl;
import service.ItemOrdersService;
import service.ItemsService;

public class ItemsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String cate = request.getParameter("category");
      if(cate==null){
        List<Items> list = ItemsService.INSTANCE.get();
        List<Categories> categories = CategoriesRepositoryImpl.INSTANCE.get();
        request.setAttribute("itemsList", list);
        request.setAttribute("categoriesList", categories);

      }else {
        List<Categories> categories = CategoriesRepositoryImpl.INSTANCE.get();
        Long cateId =0L;
        for (Categories c : categories) {
            if (c.getName().equals(cate)){
              cateId=c.getCategoryId();
              break;
            }
        }
        List<Items> list = ItemsRepositoryImpl.INSTANCE.getByCategory(cateId);
        request.setAttribute("itemsList", list);
        request.setAttribute("categoriesList", categories);
      }

    request.getRequestDispatcher("/items.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("addInCart");
    Long id = Long.parseLong(name);
    ItemOrdersService.INSTANCE.insert(id);

    resp.sendRedirect("/items");
  }
}
