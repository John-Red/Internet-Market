package servlets.filters;

import entities.Cart;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.CartService;

public class CartFilter implements Filter {

  public void init(FilterConfig filterConfig) throws ServletException {

  }

  public void doFilter(final ServletRequest request, final ServletResponse response,
      final FilterChain filterChain) throws IOException, ServletException {

    final HttpServletRequest req = (HttpServletRequest) request;
    final HttpServletResponse res = (HttpServletResponse) response;
    final HttpSession session = req.getSession();


    //Logged user.
    if ((session) != null &&
        (session.getAttribute("role")) != null ) {
      final String role = (String) session.getAttribute("role");
      moveToMenu(req, res, role, filterChain);
    } else {
      final String role = "unknown";
      moveToMenu(req, res, role, filterChain);
    }
  }

  private void moveToMenu(final HttpServletRequest req, final HttpServletResponse res,
      final String role, FilterChain filterChain) throws ServletException, IOException {
    if (role.equals("admin")||role.equals("user")) {
      req.setAttribute("userId", Cart.currentUserId);
      req.getRequestDispatcher("/cart").forward(req, res);
    } else {
      res.sendRedirect(req.getContextPath() + "/login?lang=en");
    }
  }

  public void destroy() {

  }
}