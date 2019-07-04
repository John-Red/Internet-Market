package server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.http.HttpServlet;
import java.io.File;

/** Creates Server application with tomcat first servlet is on http://localhost:8080/baseServlet */
public enum ServerApplication {
  INSTANCE;

  public void start() throws LifecycleException {
    Tomcat tomcat = new Tomcat();
    tomcat.setBaseDir("temp");
    tomcat.setPort(8080);

    String contextPath = "/";
    String docBase = new File(".").getAbsolutePath();

    Context context = tomcat.addContext(contextPath, docBase);

    HttpServlet servlet = new BaseServlet();

    String servletName = "Servlet1";
    String urlPattern = "/baseServlet";

    tomcat.addServlet(contextPath, servletName, servlet);
    context.addServletMappingDecoded(urlPattern, servletName);

    tomcat.start();
    tomcat.getServer().await();
  }
}
