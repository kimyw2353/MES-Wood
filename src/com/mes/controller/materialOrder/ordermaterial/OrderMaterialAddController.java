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
        String path = "/WEB-INF/views/materialsOrders/popup/orderMaterialAddPopup.jsp";
        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String input_orderId = req.getParameter("orderId");
        int order_id;

        if (input_orderId.isEmpty() || input_orderId == null){
            PrintWriter out = resp.getWriter();
            out.println("<script>");
            out.println("alert('다시 시도해 주세요.');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
        }else {
            OrderMaterialsDto orderMaterials = new OrderMaterialsDto();
            OrderMaterialsDao dao = new OrderMaterialsDao();
            order_id = Integer.parseInt(req.getParameter("orderId"));


        }
    }
}
