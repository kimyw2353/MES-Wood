package com.mes.controller.account;

import com.mes.dao.AccountsDao;
import com.mes.dto.AccountsDto;
import com.mes.model.Accounts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/accounts/Create.do")
public class AccountCreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/accountCreate.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Accounts accounts = new Accounts();
        AccountsDao accountsDao = new AccountsDao();

        String name = req.getParameter("name");
        String businessNumber = req.getParameter("businessNumber");
        String businessType = req.getParameter("businessType");
        String businessCategory = req.getParameter("businessCategory");
        String ceo = req.getParameter("ceo");
        String zipcode = req.getParameter("zipcode");
        String address = req.getParameter("address");
        String addressDesc = req.getParameter("addressDesc");
        String phone = req.getParameter("phone");
        String fax = req.getParameter("fax");
        String etc = req.getParameter("etc");

        //2. 가져온 데이터 Account Model 에 저장
        accounts.setName(name);
        accounts.setBusinessNumber(businessNumber);
        accounts.setBusinessType(businessType);
        accounts.setBusinessCategory(businessCategory);
        accounts.setCeo(ceo);
        accounts.setZipcode(zipcode);
        accounts.setAddress(address);
        accounts.setAddressDesc(addressDesc);
        accounts.setPhone(phone);
        accounts.setFax(fax);
        accounts.setEtc(etc);

        System.out.println(accounts);

        //거래처 생성 실행
        if (accountsDao.createAccounts(accounts)) {
            resp.sendRedirect("/accounts/List.do");
            session.setAttribute("successMessage", "거래처 등록 성공");
        } else {
            System.out.println("거래처 등록중 에러발생");
            session.setAttribute("errorMessage", "거래처 등록 에러");
        }
    }
}

