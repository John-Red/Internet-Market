package server;

import lombok.Getter;
import lombok.Setter;

public class ServerAppConfig {
  @Getter @Setter private int port;
  @Getter @Setter private String basedir;
}
