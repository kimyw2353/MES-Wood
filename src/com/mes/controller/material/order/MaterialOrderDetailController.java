package com.mes.controller.material.order;

import com.mes.dao.MaterialsOrdersDao;
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

        MaterialsOrdersDao dao = new MaterialsOrdersDao();
        MaterialsOrdersDto dto = new MaterialsOrdersDto();

        int m_OrderId = Integer.parseInt(req.getParameter("id"));

        if(!dao.findById("materialsorders", m_OrderId)){
            resp.sendRedirect("/materials/OrderList.do");
        }else {
            dto = dao.selectMaterialsOrder(m_OrderId);
            req.setAttribute("m_orderDetail", dto);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/materialsOrders/materialOrderDetail.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
