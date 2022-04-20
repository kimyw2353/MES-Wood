package com.mes.controller.materialOrder;

import com.mes.dao.MaterialsOrdersDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/materials/OrderList.do")
public class MaterialOrderListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MaterialsOrdersDao materialsOrdersDao = new MaterialsOrdersDao();

        req.setAttribute("materialsOrdersList", materialsOrdersDao.findAllMaterialsOrders());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/materialsOrders/materialOrderList.jsp");
        dispatcher.forward(req, resp);
    }

}
