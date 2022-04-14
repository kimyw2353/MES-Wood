package com.mes.controller.material;

import com.mes.dao.MaterialDao;
import com.mes.model.Materials;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/materials/Delete.do")
public class MaterialDeleteController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        MaterialDao materialDao = new MaterialDao();
        Materials materials = new Materials();

        String[] materialIds = req.getParameterValues("materialIds");
        materials.setMaterialIds(materialIds);
        ArrayList<String> result = new ArrayList<>();
        System.out.println(materials.getMaterialIds());

        int findTotalResult = materialDao.findCountByIds("materials", String.join(",", materialIds));

        if (findTotalResult == materialIds.length) {
            for (int id : materials.getMaterialIds()) {
                System.out.println(materials.getMaterialIds());
                if (materialDao.deleteMaterials(id)){
                    result.add(Integer.toString(id));
                }
            }
            if (materialIds.length == result.size()){
                session.setAttribute("successMessage", materialIds.length + " 개의 자재 정보가 삭제 되었습니다.");
                resp.sendRedirect("/materials/List.do");
            }else {
                session.setAttribute("errorMessage", "자재 정보 삭제가 실패하였습니다.");
                resp.sendRedirect("/materials/List.do");
            }
        }else {
            resp.sendRedirect("/materials/List.do");
            session.setAttribute("errrorMessage", "자재 정보가 없습니다.");
        }
    }
}
