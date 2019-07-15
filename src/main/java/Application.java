import entities.Cart;
import java.util.List;
import lombok.extern.log4j.Log4j;
import repositories.impl.CartRepositoryImpl;
import repositories.impl.ItemsRepositoryImpl;
import service.ItemsService;
import utils.DatabaseConnection;
import utils.ServerApplication;

@Log4j
public class Application {

  public static void main(String[] args) {


    try {
      ServerApplication.INSTANCE.start();
    } catch (Exception e) {
      e.getMessage();
    }
    /*List<Cart> cartList = CartRepositoryImpl.INSTANCE.get();
    for (Cart c : cartList ) {
      System.out.println(c.getItemOrdersQuantity());
    }*/
  }
}
