package server;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
@Log4j
public class ServerAppConfig {
  @Getter @Setter private int port;
  @Getter @Setter private String basedir;
  @Getter @Setter private String webappDirLocation;
  private static ServerAppConfig instance;

  private ServerAppConfig() {}

  static ServerAppConfig getInstance() {
    if (instance == null) {
      Yaml yaml = new Yaml();
      instance = new ServerAppConfig();
      InputStream inputStream =
          instance.getClass().getClassLoader().getResourceAsStream("application.yaml");
      instance = yaml.load(inputStream);
      log.info("Server configuration was read");
    }
    return instance;
  }
}
