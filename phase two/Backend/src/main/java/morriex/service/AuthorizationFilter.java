package morriex.service;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class AuthorizationFilter extends HttpFilter {
  static String allowedEndpoints = "/login,/register,/auth,/swagger,/swagger/index.html";
  @Override
  protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    System.err.println(request.getRequestURI());
    if(allowedEndpoints.contains(request.getRequestURI().toLowerCase()) || request.getMethod().equals("OPTIONS"))
    {
        chain.doFilter(request, response);
        return;
    }

    String authorizationHeader = request.getHeader("Authorization");
    System.err.println(authorizationHeader);
    try {
      if (JwtService.validateToken(authorizationHeader)) {
        chain.doFilter(request, response);
        return;
      }
      response.setStatus(401);
    } catch (Exception e) {
      response.setStatus(401);
    }
  }
}
