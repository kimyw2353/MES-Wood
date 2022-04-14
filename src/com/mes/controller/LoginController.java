package com.mes.controller;

import com.mes.dao.UsersDao;
import com.mes.dto.UsersDto;
import com.mes.manager.AuthManager;
import com.mes.model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(session.getAttribute("SESSION_ID") == null){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void notExistUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("errorMessage", "존재하지 않는 아이디 입니다.");
        resp.sendRedirect("/login.do");
    }

    private void notMatchPassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
        resp.sendRedirect("/login.do");
    }

    private void databaseAccessError(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("errorMessage", "DB접근 에러.");
        resp.sendRedirect("/login.do");
    }

    private void loginSuccessful(HttpServletRequest req, HttpServletResponse resp, Users users) throws IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("SESSION_ID", users.getId());
        session.setAttribute("SESSION_USER_ID", users.getUserId());
        session.setAttribute("SESSION_NAME", users.getName());
        resp.sendRedirect("/main.do");

        System.out.println("로그인 아이디 : " + users.getUserId());
        System.out.println("로그인 이름명 : " +users.getName());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersDto usersDto = (UsersDto) req.getAttribute("userDTO");

        AuthManager authManager = new AuthManager();
        UsersDao usersDao = new UsersDao();
        Users users = authManager.getUser(usersDto.getUserId());
        int loginResult = usersDao.findUserByUserId(usersDto.getUserId());

        if(loginResult == 2){
            this.databaseAccessError(req,resp);
        }else if (loginResult == 0) {
            this.notExistUser(req, resp);
        }else {
            if (authManager.matchPassword(users, usersDto.getPassword())) {
                this.loginSuccessful(req, resp, users);
            } else {
                this.notMatchPassword(req, resp);
            }
        }
    }
}
