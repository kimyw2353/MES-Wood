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
        boolean orderCheck = false;

        dto.setId(Integer.parseInt(req.getParameter("m_code")));
        dto.setName(req.getParameter("m_name"));
        dto.setAccount_id(Integer.parseInt(req.getParameter("account_id")));
        dto.setEtc(req.getParameter("m_etc"));

        System.out.println(dto.toString());

        if(dto.getId() >= dao.findLastId()){
            dto.setId(dao.findLastId());
        }

        //유효성체크 해야함

        orderCheck = dao.createMaterialsOrders(dto);
        System.out.println("orderCheck : " + orderCheck);

        String loc;
        if(orderCheck){
            loc = "/materials/Order.do";
            session.setAttribute("successMessage", "발주 등록 완료");
        }else {
            loc = "javascript:history.back()";
            session.setAttribute("errorMessage", "발주 등록 실패");
        }
        resp.sendRedirect(loc);
    }
}
