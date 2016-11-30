package ironyard.security;

import ironyard.data.EventPlanner;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by favianalopez on 11/15/16.
 */
public class SecurityFilter implements javax.servlet.Filter {

    /**
     * filters the pages that need security
     * @param request Extends the ServletRequest interface, provides request information for HTTP servlets
     * @param response Extends the ServletResponse interface, provides response information for HTTP servlets
     * @param chain security filter
     * @throws IOException
     * @throws ServletException
     */

        @Override
        public void doFilter(ServletRequest request, ServletResponse response,
                             FilterChain chain) throws IOException, ServletException {
            HttpServletRequest req = ((HttpServletRequest) request);
            HttpServletResponse resp = ((HttpServletResponse) response);

            EventPlanner eventPlanner = (EventPlanner) req.getSession().getAttribute("eventPlanner");
            boolean authorized = (eventPlanner != null);

            if(!authorized) {

                String uri = req.getRequestURI();
                authorized = uri.endsWith("/login") || uri.endsWith("login.jsp") || uri.endsWith("createNewEventPlanner.jsp") || uri.endsWith("newEventPlanner");

            }
            if(authorized) {
                chain.doFilter(request, response);

            }else{
                resp.sendRedirect("/login.jsp");
            }
        }

        @Override
        public void destroy() {
        }

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }

}
