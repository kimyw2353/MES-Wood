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

@WebServlet("/materials/Detail.do")
public class MaterialDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MaterialDao materialDao = new MaterialDao();

        int materialId = Integer.parseInt(req.getParameter("id"));

        if (!materialDao.findById("materials", materialId)){
            resp.sendRedirect("/materials/List.do");
        }else {
            req.setAttribute("materialsDetail", materialDao.findMaterials(materialId));
            System.out.println("materialId : " + materialId);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/material/materialDetail.jsp");
            dispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        MaterialDao materialDao = new MaterialDao();
        Materials materials = new Materials();

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("m_name");
        String code = req.getParameter("m_code");
        int accountId = Integer.parseInt(req.getParameter("account_id"));
        String accountName = req.getParameter("a_name");
        String width = req.getParameter("m_width");
        String height = req.getParameter("m_height");
        String etc = req.getParameter("m_etc");

        materials.setId(id);
        materials.setName(name);
        materials.setCode(code);
        materials.setAccountId(accountId);
        materials.setAccountName(accountName);
        materials.setWidth(width);
        materials.setHeight(height);
        materials.setEtc(etc);

        System.out.println("자재 정보 변경 : " + id);

        if (materialDao.updateMaterials(materials)){
            resp.sendRedirect("/materials/Detail.do?id=" + materials.getId());
            session.setAttribute("successMessage", "자재 정보 수정 완료 되었습니다.");
        }else {
            resp.sendRedirect("/materials/Detail.do?id=" + materials.getId());
            session.setAttribute("errorMessage", "자재 정보 수정이 실패하였습니다.");
        }
    }
}
