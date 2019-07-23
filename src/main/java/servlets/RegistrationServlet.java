package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j;
import org.springframework.util.DigestUtils;
import service.UsersService;
import utils.exeptions.InvalidLoginOrPassword;

@Log4j
public class RegistrationServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String login = req.getParameter("login");
    String password = DigestUtils.md5DigestAsHex(req.getParameter("pass").getBytes());
    try {
      UsersService.INSTANCE.insert(login, password);
    } catch (InvalidLoginOrPassword e) {
      log.error(e);
    }
    resp.sendRedirect("/login?lang=en");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/registration.jsp").forward(req, resp);
  }
}
