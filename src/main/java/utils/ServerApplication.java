package utils;

import java.io.File;
import lombok.extern.log4j.Log4j;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

/**
 * Creates Server application with tomcat all servlets is on http://localhost:8080/ +
 * servletname.jsp
 */
@Log4j
public enum ServerApplication {
  INSTANCE;

  private ServerAppConfig config;

  public void start() throws LifecycleException {
    // init configuration
    configInit();

    // create server
    Tomcat tomcat = new Tomcat();

    // config port
    int webPort = config.getPort();
    tomcat.setPort(webPort);

    // creating a context
    Context ctx = tomcat.addWebapp("/", new File(config.getWebappDirLocation()).getAbsolutePath());

    log.info("configuring app with basedir: " + config.getWebappDirLocation());

    // Declare an alternative location for "WEB-INF/classes" dir
    File additionWebInfClasses = new File("target/classes/servlets");
    WebResourceRoot resources = new StandardRoot(ctx);
    resources.addPreResources(
        new DirResourceSet(resources, "/", additionWebInfClasses.getAbsolutePath(), "/"));
    ctx.setResources(resources);

    // starting server
    tomcat.start();
    tomcat.getServer().await();
  }

  private void configInit() {
    config = ServerAppConfig.getInstance();
  }
}
