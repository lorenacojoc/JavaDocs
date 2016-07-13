package ro.teamnet.zth.web;

import ro.teamnet.zth.file.LogFileWriter;

import javax.management.Attribute;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Lorena on 7/13/2016.
 */
public class HeadersLogFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        LogFileWriter log = new LogFileWriter();
        Enumeration headers = ((HttpServletRequest) servletRequest).getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = (String) headers.nextElement();
            String headerValue = ((HttpServletRequest)servletRequest).getHeader(headerName);
                LogFileWriter.logHeader(headerName, headerValue);

            }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
