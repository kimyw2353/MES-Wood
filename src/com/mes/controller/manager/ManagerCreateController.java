package com.mes.controller.manager;

import com.mes.dao.ManagersDao;
import com.mes.dto.ManagersDto;
import com.mes.model.Managers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/managers/Create.do")
public class ManagerCreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/manager/managerCreate.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        ManagersDao managersDao = new ManagersDao();
        Managers managers = new Managers();

        int a_id = Integer.parseInt(req.getParameter("account_id"));

        String m_name = req.getParameter("m_name");
        String m_email = req.getParameter("m_email");
        String m_phone = req.getParameter("m_phone");
        String m_position = req.getParameter("m_position");
        String m_department = req.getParameter("m_department");


        managers.setName(m_name);
        managers.setAccountId(a_id);
        managers.setEmail(m_email);
        managers.setPhone(m_phone);
        managers.setPosition(m_position);
        managers.setDepartment(m_department);


        if (managersDao.createManagers(managers)) {
            resp.sendRedirect("/managers/List.do");
            session.setAttribute("successMessage", "관리자 등록 완료");
        } else {
            System.out.println("관리자 등록중 에러발생");
            session.setAttribute("errorMessage", "관리자 등록 에러");
        }
    }
}

