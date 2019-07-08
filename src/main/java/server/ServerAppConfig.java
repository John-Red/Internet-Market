package server;

import lombok.Getter;
import lombok.Setter;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;

public class ServerAppConfig {
  @Getter @Setter private int port;
  @Getter @Setter private String basedir;
  private static ServerAppConfig instance;

  private ServerAppConfig() {}

  static ServerAppConfig getInstance() {
    if (instance == null) {
      Yaml yaml = new Yaml();
      instance = new ServerAppConfig();
      InputStream inputStream =
          instance.getClass().getClassLoader().getResourceAsStream("application.yaml");
      instance = yaml.load(inputStream);
    }
    return instance;
  }
}
