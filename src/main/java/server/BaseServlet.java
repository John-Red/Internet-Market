package server;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    PrintWriter writer = resp.getWriter();

    writer.println("<html><title>Base Servlet</title><body>");
    writer.println("<h1>Welcome to Epam EXPRESS!</h1>");
    writer.println("</body></html>");
  }
}
