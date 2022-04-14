package com.mes.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "sessionFilter")
public class SessionFilter implements Filter {

    private final List<String> whiteList;

    //세션 제외 경로 추가
    public SessionFilter(){
        whiteList = new ArrayList<String>();
        whiteList.add("/");
        whiteList.add("/register.do");
        whiteList.add("/login.do");
        whiteList.add("/logout.do");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String uri = req.getRequestURI();

        //세션이 필요한 경로일 경우

        if(whiteList.contains(uri) || uri.startsWith("/js/") || uri.startsWith("/css/") ||uri.startsWith("/images/") || uri.startsWith("/fonts/")) {//
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            if (session.getAttribute("SESSION_ID") == null) {//세션이 없을경우
                session.setAttribute("errorMessage","로그인이 필요한 페이지 입니다.");
                resp.sendRedirect("/login.do");//로그인 페이지로 이동
            }else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }

    }

    @Override
    public void destroy() {

    }





}
