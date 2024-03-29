package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.util.DigestUtils;
import service.UsersService;

public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    final HttpSession session = req.getSession();
    // check logged or not
    if ((session.getAttribute("role")) != null) {
      res.sendRedirect(req.getContextPath() + "/items?lang=en");
    } else {
      req.getRequestDispatcher("/login.jsp").forward(req, res);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    final String login = req.getParameter("login");
    final String password = DigestUtils.md5DigestAsHex(req.getParameter("password").getBytes());
    if (!(UsersService.INSTANCE.isUserActive(login))) {
      req.getRequestDispatcher("/warningBlocked.jsp").forward(req, res);
      ;
    } else if (login != null
        && password != null
        && UsersService.INSTANCE.isUserExist(login)
        && UsersService.INSTANCE.validatePassword(password, login)) {
      final String role = UsersService.INSTANCE.getRoleByLogin(login);
      req.getSession().setAttribute("role", role);
      req.getSession().setAttribute("login", login);
      res.sendRedirect(req.getContextPath() + "/items?lang=en");
    } else {
      res.sendRedirect(req.getContextPath() + "/login?lang=en");
    }
  }
}
