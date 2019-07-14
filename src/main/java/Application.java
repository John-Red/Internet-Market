import static org.apache.log4j.spi.Configurator.NULL;

import entities.ItemOrders;
import entities.Items;
import lombok.extern.log4j.Log4j;
import repositories.impl.ItemOrderRepositoryImpl;
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
