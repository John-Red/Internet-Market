package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UsersService;

public class RegistrationServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String login = req.getParameter("login");
    String password = req.getParameter("pass");
    if (UsersService.INSTANCE.loginIsValid(login)
        & UsersService.INSTANCE.passwordIsValid(password)) {
      UsersService.INSTANCE.insert(login, password);
      resp.sendRedirect("/");
    } else {
      req.setAttribute("incorrect", "incorrect login or password");
      doGet(req, resp);
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/registration.jsp").forward(req, resp);
  }
}
