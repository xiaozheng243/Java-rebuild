package online.suiyu.springdemo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "userFilter", urlPatterns = {"/index/*"})
public class UserFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger("UserFilter.class");

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("UserFilter开始");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("UserFilter工作区");
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        Object sex = httpServletRequest.getAttribute("sex");
//        logger.info(sex.toString());
//        System.err.println(sex);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("UserFilter结束");
    }
}
