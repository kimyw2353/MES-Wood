package com.mes.controller.material.order;

import com.mes.dao.MaterialsOrdersDao;
import com.mes.dto.MaterialsOrdersDto;
import com.mes.model.Materials;
import com.mes.model.MaterialsOrders;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet("/materials/Order/Create.do")
public class MaterialOrderCreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MaterialsOrdersDao dao = new MaterialsOrdersDao();
        int lastId = dao.findLastId()+1;
        //등록 도중 다른 사람이 먼저 등록해버리는 경우에 에러가 날 수 있다.
        req.setAttribute("lastId", lastId);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/materialsOrders/materialOrderCreate.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MaterialsOrdersDto dto = new MaterialsOrdersDto();
        MaterialsOrdersDao dao = new MaterialsOrdersDao();
        String number = req.getParameter("m_number");
        String name = req.getParameter("m_name");
        String account_id = req.getParameter("account_id");
        boolean orderCheck = false;
        int int_account_id = 0;
        String orderDate = req.getParameter("m_order");
        String etc = req.getParameter("m_etc");
        if(name==null || name.isEmpty() || account_id==null || account_id.isEmpty()){
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<script>");
            out.println("alert('발주명과 거래처명은 필수 입력사항입니다.');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
        }else{
            if(orderDate==null||orderDate.isEmpty()){
                orderDate = "default";
            }
            int_account_id = Integer.parseInt(account_id);
            dto.setId(dao.findLastId());
            dto.setNumber(number);
            dto.setName(name);
            dto.setAccount_id(int_account_id);
            dto.setOrderDate(orderDate);
            dto.setEtc(etc);

            orderCheck = dao.createMaterialsOrders(dto);
        }

        String loc;
        if(orderCheck){
            loc = "/materials/OrderList.do";
            session.setAttribute("successMessage", "발주 등록 완료");
        }else {
            loc = "javascript:history.back()";
            session.setAttribute("errorMessage", "발주 등록 실패");
        }
        resp.sendRedirect(loc);
    }
}
