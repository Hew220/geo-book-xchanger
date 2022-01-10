package hu.wup.geobookxchanger.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

public class SpecificUrlPatternFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(BookRequestLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("SpecificUrlPatternFilter - doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
