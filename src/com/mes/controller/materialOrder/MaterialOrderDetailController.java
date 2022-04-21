package com.mes.controller.materialOrder;

import com.mes.dao.MaterialDao;
import com.mes.dao.MaterialsOrdersDao;
import com.mes.dao.OrderMaterialsDao;
import com.mes.dto.MaterialsOrdersDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/materials/OrderDetail.do")
public class MaterialOrderDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        MaterialsOrdersDao orderDao = new MaterialsOrdersDao();
        OrderMaterialsDao dao = new OrderMaterialsDao();

        int m_OrderId = Integer.parseInt(req.getParameter("id"));

        if(!dao.findById("materialsorders", m_OrderId)){
            resp.sendRedirect("/materials/OrderList.do");
        }else {
            req.setAttribute("orderDetail", orderDao.selectMaterialsOrder(m_OrderId));
            req.setAttribute("materialsList", dao.findMaterialsByOrderId(m_OrderId));
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/materialsOrders/materialOrderDetail.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
