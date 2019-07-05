package server;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerAppConfig {
  private int port;
  private String basedir;
}
