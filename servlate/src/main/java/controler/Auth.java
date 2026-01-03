package controler;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Auth implements Filter {

        @Override
        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
                throws IOException, ServletException {
            // TODO Auto-generated method stub
            System.out.println("Filter called....");
            HttpServletRequest request = (HttpServletRequest)req;
            HttpServletResponse response = (HttpServletResponse)res;

            HttpSession session = request.getSession();
            Object status = session.getAttribute("isLoggedIn");
            if(status!=null) {
                chain.doFilter(request, response);
            }
            else {
                response.sendRedirect("index.jsp");
            }
        }

    }

