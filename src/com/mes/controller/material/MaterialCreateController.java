package com.mes.controller.material;

import com.mes.dao.MaterialDao;
import com.mes.model.Materials;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/materials/Create.do")
public class MaterialCreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/material/materialCreate.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        MaterialDao materialDao = new MaterialDao();
        Materials materials = new Materials();


        String m_code = req.getParameter("m_code");
        String m_name = req.getParameter("m_name");
        int a_id = Integer.parseInt(req.getParameter("account_id"));
        String m_height = req.getParameter("m_height");
        String m_width = req.getParameter("m_width");
        String m_etc = req.getParameter("m_etc");
        
        materials.setCode(m_code);
        materials.setName(m_name);
        materials.setAccountId(a_id);
        materials.setHeight(m_height);
        materials.setWidth(m_width);
        materials.setEtc(m_etc);

        if (materialDao.createMaterials(materials)){
            resp.sendRedirect("/materials/List.do");
            session.setAttribute("successMessage", "자재 등록 완료");
        }else {
            System.out.println("자재 등록 중 에러 발생");
            session.setAttribute("errorMessage", "자재 등록 에러");
        }
    }


}
