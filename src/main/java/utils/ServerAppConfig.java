package utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;

@Log4j
@Getter
@Setter
public class ServerAppConfig {

  private int port;
  private String basedir;
  private String databaseUrl;
  private String databaseUsername;
  private String databasePassword;
  private String webappDirLocation;

  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
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
