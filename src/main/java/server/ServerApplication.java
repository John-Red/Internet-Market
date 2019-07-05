package server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.yaml.snakeyaml.Yaml;

import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.InputStream;

/** Creates Server application with tomcat first servlet is on http://localhost:8080/baseServlet */
public enum ServerApplication {
  INSTANCE;

  private static final String SERVLET_NAME = "Servlet1";
  private static final String URL_PATTERN = "/baseServlet";
  ServerAppConfig config;


  public void start() throws LifecycleException {
    configInit();

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

  private void configInit (){
    Yaml yaml = new Yaml();
    InputStream inputStream =
            this.getClass().getClassLoader().getResourceAsStream("application.yaml");
    config = yaml.load(inputStream);
  }
}
