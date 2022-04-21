package com.mes.controller.materialOrder.ordermaterial;

import com.mes.dao.OrderMaterialsDao;
import com.mes.dto.OrderMaterialsDto;
import com.mes.model.OrderMaterials;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/orderMaterial/MaterialAdd.do")
public class OrderMaterialAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int order_id = Integer.parseInt(req.getParameter("orderId"));
        req.setAttribute("orderId", order_id);

        String path = "/WEB-INF/views/materialsOrders/popup/orderMaterialAddPopup.jsp";
        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        OrderMaterialsDao dao = new OrderMaterialsDao();
        boolean check = false;

        int amount = Integer.parseInt(req.getParameter("amount"));
        int price = Integer.parseInt(req.getParameter("price"));
        int order_id = Integer.parseInt(req.getParameter("order_id"));
        int m_id = Integer.parseInt(req.getParameter("m_id"));

        dao.createOrderMaterials(amount, price, order_id, m_id);

        String loc;
        if(check){
            loc = "/materials/OrderDetail.do?id="+req.getParameter("order_id");
            session.setAttribute("successMessage", "자재 추가 완료");
        }else{
            loc = "javascript:history.back()";
            session.setAttribute("errorMessage", "자재 추가 실패");
        }
        resp.sendRedirect(loc);

    }
}
