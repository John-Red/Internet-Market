import lombok.extern.log4j.Log4j;
import repositories.impl.ItemsRepositoryImpl;
import service.ItemsService;
import utils.ServerApplication;

@Log4j
public class Application {

  public static void main(String[] args) {
    log.info("Application is started");

    try {
      ServerApplication.INSTANCE.start();
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
}
