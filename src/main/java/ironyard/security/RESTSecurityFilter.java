package ironyard.security;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by favianalopez on 11/29/16.
 */
public class RestSecurityFilter implements javax.servlet.Filter {

    /**
     * verify authorization key is valid, if it is not valid redirect to error message
     * @param request Extends the ServletRequest interface, provides request information for HTTP servlets
     * @param response Extends the ServletResponse interface, provides response information for HTTP servlets
     * @param chain security filter
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        // check for key based on authentication
        boolean authorized = false;
        String key = req.getHeader("x-authorization-key");

        //key is validated grant access
        if(key != null){
            authorized = SecurityUtils.isValidKey(key);
        }
        if(authorized){
            chain.doFilter(request, response);

        //key is not validated redirect error message
        }else{
            res.setStatus(HttpServletResponse.SC_FORBIDDEN);
            res.getWriter().println("<html><body><p>Incorrect key, please try again</p></body></html>");
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}

