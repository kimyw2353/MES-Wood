package com.mes.controller;

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

@WebServlet("/register.do")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/register.jsp");
        dispatcher.forward(req, resp);
    }

    private void existUserId(HttpSession session, HttpServletResponse resp) throws IOException {
        session.setAttribute("errorMessage", "중복 아이디가 존재 합니다.");
        resp.sendRedirect("/register.do");
    }

    private void userCreationError(HttpSession session, HttpServletResponse resp) throws IOException {
        session.setAttribute("errorMessage", "회원 생성에 오류가 발생 하였습니다.");
        resp.sendRedirect("/register.do");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);

        String userId = req.getParameter("userId");
        String userName = req.getParameter("name");
        String userPassword = req.getParameter("password");

        AuthManager authManager = new AuthManager();

        Users users = authManager.getUser(userId);

        if (users != null) {
            this.existUserId(session, resp);
        } else {
            if (authManager.createUser(userId, userPassword, userName)) {
                session.setAttribute("successMessage", "회원 가입 하였습니다.");
                resp.sendRedirect("/login.do");
            } else {
                this.userCreationError(session, resp);
            }
        }

    }
}
