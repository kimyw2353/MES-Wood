package com.mes.controller.manager;

import com.mes.dao.ManagersDao;
import com.mes.model.Managers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/managers/Delete.do")
public class ManagerDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        ManagersDao managersDao = new ManagersDao();
        Managers managers = new Managers();

        String[] managerIds = req.getParameterValues("managerIds");
        managers.setManagerIds(managerIds);
        ArrayList<String> result = new ArrayList<>();
        System.out.println(managers.getManagerIds());

        int findTotalResult = managersDao.findCountByIds("managers", String.join("," , managerIds));

        if (findTotalResult == managerIds.length){
            for (int id : managers.getManagerIds()){
                System.out.println(managers.getManagerIds());
                if (managersDao.deleteManagers(id)){
                    result.add(Integer.toString(id));
                }
            }
            if (managerIds.length == result.size()){
                session.setAttribute("successMessage", managerIds.length + " 개의 매니저가 삭제 되었습니다.");
                resp.sendRedirect("/managers/List.do");
            }else {
                session.setAttribute("errorMessage", "매니저 정보 삭제가 실패하였습니다.");
                resp.sendRedirect("/managers/List.do");
            }
        }else{
            resp.sendRedirect("/managers/List.do");
            session.setAttribute("errorMessage", "매니저 정보가 없습니다.");
        }

    }
}
