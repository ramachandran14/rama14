package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) {

        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {

        filterConfig = null;
    }

    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        String user_name = req.getParameter("user_name");
        String password = req.getParameter("password");

        if((user_name.equals("rama")) && (password.equals("chandran"))) {
            PrintWriter out = res.getWriter();
            out.println("Authentication Successful");
            req.setAttribute("user",user_name);
            chain.doFilter(req, res);

        } else {

            PrintWriter out = res.getWriter();
            out.println("Provided Username or password is incorrect");
        }
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {

    }
}
