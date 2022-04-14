package com.mes.filter;

import com.mes.dto.UsersDto;
import com.mes.role.UserIdRole;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/login.do")
public class LoginFilter extends UserIdRole implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(true);

        UsersDto usersDto = new UsersDto();

        if (request.getMethod().equals("GET")) {
            if (session.getAttribute("SESSION_ID") != null) {
                response.sendRedirect("main.do");
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } else {

            if (request.getParameter("user_id").trim().equals("") || request.getParameter("password").trim().equals("")) {
                session.setAttribute("errorMessage", "아이디와 비밀번호를 입력해 주세요.");
                response.sendRedirect("/login.do");
            } else if (!isRolePass(request.getParameter("user_id"))) {
                session.setAttribute("errorMessage", "아이디에 특수문자를 사용할 수 없습니다.");
                response.sendRedirect("/login.do");
            } else {
                usersDto.setUserId(request.getParameter("user_id"));
                usersDto.setPassword(request.getParameter("password"));
                request.setAttribute("userDTO", usersDto);
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
