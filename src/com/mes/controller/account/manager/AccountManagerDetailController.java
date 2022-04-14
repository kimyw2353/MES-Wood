package com.mes.controller.account.manager;

import com.mes.dao.ManagersDao;
import com.mes.model.Managers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/account/ManagerDetail.do")
public class AccountManagerDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ManagersDao managersDao = new ManagersDao();

        int id = Integer.parseInt(req.getParameter("id"));

        req.setAttribute("managersDetail", managersDao.findAccountsByManagerId(id));
        System.out.println("accountId : " + id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/popup/managerDetailPopup.jsp");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ManagersDao managersDao = new ManagersDao();
        Managers managers = new Managers();

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String position = req.getParameter("position");
        String department = req.getParameter("department");

        managers.setId(id);
        managers.setName(name);
        managers.setEmail(email);
        managers.setPhone(phone);
        managers.setPosition(position);
        managers.setDepartment(department);

        System.out.println(managers);

        managersDao.updateAccountsManagers(managers);

    }
}
