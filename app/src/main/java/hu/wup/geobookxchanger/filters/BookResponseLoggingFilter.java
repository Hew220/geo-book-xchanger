package hu.wup.geobookxchanger.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(2)
public class BookResponseLoggingFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(BookRequestLoggingFilter.class);


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("BookResponseLoggingFilter - doFilter");
//        logger.info("local Port: " + servletRequest.getLocalPort());
//        logger.info("Server name: " + servletRequest.getServerName());
//        logger.info("Protocol: " + servletRequest.getProtocol());
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        logger.info("Method: " + httpServletRequest.getMethod());
//        logger.info("requestURI: " + httpServletRequest.getRequestURI());
//        logger.info("Servlet path: " + httpServletRequest.getServletPath());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
