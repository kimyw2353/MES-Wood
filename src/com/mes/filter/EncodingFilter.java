package com.mes.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "encodingFilter")
public class EncodingFilter implements Filter {
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String encoding = "UTF-8";
        if(servletRequest.getCharacterEncoding() == null || servletResponse.getCharacterEncoding() == null){
            servletRequest.setCharacterEncoding(encoding);
            servletResponse.setCharacterEncoding(encoding);
        }

        filterChain.doFilter(servletRequest,servletResponse);

//        servletResponse.setContentType("application/json;charset=UTF-8");
//        servletResponse.setCharacterEncoding("UTF-8");
//        servletRequest.setCharacterEncoding("UTF-8");
//        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
