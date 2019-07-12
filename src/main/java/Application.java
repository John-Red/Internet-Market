import lombok.extern.log4j.Log4j;
import repositories.impl.ItemsRepositoryImpl;
import service.ItemsService;
import utils.ServerApplication;

@Log4j
public class Application {

  public static void main(String[] args) {


    try {
      ServerApplication.INSTANCE.start();
    } catch (Exception e) {
      e.getMessage();
    }
  }
}
