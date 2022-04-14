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
import java.io.IOException;

@WebServlet("/managers/List.do")
public class ManagerListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ManagersDao managersDao = new ManagersDao();

        req.setAttribute("managersList", managersDao.findAllManagers());
        req.setAttribute("managerTotalCount", managersDao.managersCount());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/manager/managerList.jsp");
        dispatcher.forward(req, resp);
    }

}

