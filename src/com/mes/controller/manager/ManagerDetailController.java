package com.mes.controller.manager;

import com.mes.dao.ManagersDao;
import com.mes.model.Managers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/managers/Detail.do")
public class ManagerDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ManagersDao managersDao = new ManagersDao();

        int managerId = Integer.parseInt(req.getParameter("id"));

        if (!managersDao.findById("managers", managerId)){
            resp.sendRedirect("/managers/List.do");
        }else {
            req.setAttribute("managersDetail", managersDao.findManagers(managerId));
            System.out.println("managerId : " + managerId);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/manager/managerDetail.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        ManagersDao managersDao = new ManagersDao();
        Managers managers = new Managers();

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("m_name");
        int accountId = Integer.parseInt(req.getParameter("account_id"));
        String accountName = req.getParameter("account_name");
        String email = req.getParameter("m_email");
        String phone = req.getParameter("m_phone");
        String position = req.getParameter("m_position");
        String department = req.getParameter("m_department");

        managers.setId(id);
        managers.setName(name);
        managers.setAccountId(accountId);
        managers.setAccountName(accountName);
        managers.setEmail(email);
        managers.setPhone(phone);
        managers.setPosition(position);
        managers.setDepartment(department);

        System.out.println("매니저 정보 변경 : " + managers);

        if (managersDao.updateManagers(managers)){
            resp.sendRedirect("/managers/Detail.do?id=" + managers.getId());
            session.setAttribute("successMessage", "매니저 정보가 수정 되었습니다.");
        }else {
            resp.sendRedirect("/managers/Detail.do?id=" + managers.getId());
            session.setAttribute("errorMessage", "매니저 정보 수정이 실패하였습니다.");
        }
    }
}
