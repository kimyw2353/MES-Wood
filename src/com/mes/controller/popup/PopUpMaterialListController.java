package com.mes.controller.popup;

import com.mes.dao.AccountsDao;
import com.mes.dao.MaterialsOrdersDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/popup/MaterialsOrderList.do")
public class PopUpMaterialListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AccountsDao accountsDao = new AccountsDao();
        MaterialsOrdersDao dao = new MaterialsOrdersDao();

        req.setAttribute("m_orderList", dao.findAllMaterialsOrders());
        req.setAttribute("m_totalCount", dao.MaterialordersCount());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/popup/materialListPopup.jsp");
        dispatcher.forward(req, resp);
    }

}
