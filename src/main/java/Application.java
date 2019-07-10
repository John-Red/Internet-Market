import entities.Users;
import java.util.List;
import repositories.UsersRepository;
import repositories.impl.UsersRepositoryImpl;
import utils.DatabaseConnection;
import utils.ServerApplication;
import lombok.extern.log4j.Log4j;


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
