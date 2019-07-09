package server;

import lombok.extern.log4j.Log4j;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import javax.servlet.http.HttpServlet;
import java.io.File;

/** Creates Server application with tomcat first servlet is on http://localhost:8080/baseServlet */
@Log4j
public enum ServerApplication {
  INSTANCE;

  private static final String SERVLET_NAME = "Servlet1";
  private static final String URL_PATTERN = "/baseServlet";
  private ServerAppConfig config;

  public void start() throws LifecycleException {
    configInit();
    log.info("ServerApplicatin is started");

    Tomcat tomcat = new Tomcat();
    tomcat.setBaseDir(config.getBasedir());
    tomcat.setPort(config.getPort());

    String contextPath = "";
    String docBase = new File(".").getAbsolutePath();

    Context context = tomcat.addContext(contextPath, docBase);

    HttpServlet servlet = new BaseServlet();

    tomcat.addServlet(contextPath, SERVLET_NAME, servlet);
    context.addServletMappingDecoded(URL_PATTERN, SERVLET_NAME);

    tomcat.start();
    tomcat.getServer().await();
  }

  private void configInit() {
    config = ServerAppConfig.getInstance();
  }
}
