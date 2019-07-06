import org.apache.log4j.Logger;
import server.ServerApplication;

public class Application {

  private static final Logger LOGGER = Logger.getLogger(Application.class.getSimpleName());
  public static void main(String[] args) {
    LOGGER.info("Application is started");
    try {
      ServerApplication.INSTANCE.start();
    } catch (Exception e) {
      LOGGER.error("ServerApplication exeption");
      e.printStackTrace();
    }
  }
}
