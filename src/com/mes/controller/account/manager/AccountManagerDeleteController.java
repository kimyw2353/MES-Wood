package com.mes.controller.account.manager;

import com.mes.dao.ManagersDao;
import com.mes.model.Managers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/account/ManagerDelete.do")
public class AccountManagerDeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        HttpSession session = req.getSession();

        ManagersDao managersDao = new ManagersDao();
        Managers managers = new Managers();
        managers.setManagerIds(req.getParameter("managerIds").split(","));
        ArrayList<Integer> ids = new ArrayList<Integer>();

        for (int id : managers.getManagerIds()){
            managersDao.deleteAccountsManagers(req.getParameter("account_id"), id);
            ids.add(id);
        }

        if (managers.getManagerIds().size() == ids.size()){
            session.setAttribute("successMessage", ids.size() + "개의 담당자 정보가 삭제되었습니다.");
            resp.sendRedirect("/account/ManagerDetail.do?id="+req.getParameter("account_id"));
        }else {
            session.setAttribute("errorMessage", "담당자 정보 삭제가 실패하였습니다.");
            resp.sendRedirect("/account/ManagerDetail.do?id="+req.getParameter("account_id"));
        }
    }
}
