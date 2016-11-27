package Filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FilterConnect implements Filter
{
    private FilterConfig config = null;

    public void init (FilterConfig config) throws ServletException
    {

    }
    public void doFilter (ServletRequest request, ServletResponse response,
                          FilterChain chain) throws IOException,
            ServletException
    {
        HttpServletResponse httpResp = (HttpServletResponse)response;
        httpResp.addHeader("Access-Control-Allow-Origin", "*");
        httpResp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        httpResp.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        httpResp.addHeader("Access-Control-Max-Age", "1728000");
        chain.doFilter(request, response);
    }
    public void destroy()
    {
        config = null;
    }
}
