package com.mes.controller.account.manager;

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

@WebServlet("/account/ManagerCreate.do")
public class AccountManagerCreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/popup/managerCreatePopup.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Managers managers = new Managers();
        ManagersDao managersDao = new ManagersDao();

        int accountId = Integer.parseInt(req.getParameter("accountId"));


        String m_name = req.getParameter("m_name");
        String m_email = req.getParameter("m_email");
        String m_phone = req.getParameter("m_phone");
        String m_position = req.getParameter("m_position");
        String m_department = req.getParameter("m_department");

        managers.setAccountId(accountId);

        managers.setName(m_name);
        managers.setEmail(m_email);
        managers.setPhone(m_phone);
        managers.setPosition(m_position);
        managers.setDepartment(m_department);


        managersDao.createAccountsManager(managers);

    }
}

