package server;

import lombok.extern.log4j.Log4j;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

/** Creates Server application with tomcat first servlet is on http://localhost:8080/ */
@Log4j
public enum ServerApplication {
  INSTANCE;

  private ServerAppConfig config;

  public void start() throws LifecycleException, ServletException {
    // init configuration
    configInit();

    // create server
    Tomcat tomcat = new Tomcat();

    // config port
    int webPort = config.getPort();
    tomcat.setPort(webPort);

    // creating a context
    StandardContext ctx =
        (StandardContext)
            tomcat.addWebapp("/", new File(config.getWebappDirLocation()).getAbsolutePath());

    log.info(
        "configuring app with basedir: "
            + new File("./" + config.getWebappDirLocation()).getAbsolutePath());

    // Declare an alternative location for "WEB-INF/classes" dir
    File additionWebInfClasses = new File("target/classes");
    WebResourceRoot resources = new StandardRoot(ctx);
    resources.addPreResources(
        new DirResourceSet(
            resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
    ctx.setResources(resources);

    tomcat.start();
    tomcat.getServer().await();
  }

  private void configInit() {
    config = ServerAppConfig.getInstance();
  }
}
