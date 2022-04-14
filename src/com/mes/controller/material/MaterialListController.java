package com.mes.controller.material;

import com.mes.dao.MaterialDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/materials/List.do")
public class MaterialListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MaterialDao materialDao = new MaterialDao();

        req.setAttribute("materialsList", materialDao.findAllMaterials());
        req.setAttribute("materialsCount", materialDao.materialsCount());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/material/materialList.jsp");
        dispatcher.forward(req, resp);
    }

}
