package com.mes.controller.popup;

import com.mes.dao.AccountsDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/popup/AccountList.do")
public class PopUpAccountListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AccountsDao accountsDao = new AccountsDao();

        req.setAttribute("accountsList", accountsDao.findAllAccounts());
        req.setAttribute("accountsTotalCount", accountsDao.accountsCount());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/popup/accountListPopup.jsp");
        dispatcher.forward(req, resp);
    }

}
