package com.mes.controller.account;

import com.mes.dao.AccountsDao;
import com.mes.dao.ManagersDao;
import com.mes.model.Accounts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/accounts/Detail.do")
public class AccountDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        AccountsDao accountsDao = new AccountsDao();
        ManagersDao managersDao = new ManagersDao();

        int accountsId = Integer.parseInt(request.getParameter("id"));

        if (!accountsDao.findById("accounts", accountsId)){
            response.sendRedirect("/accounts/List.do");
        }else {
            request.setAttribute("accountsDetail", accountsDao.selectAccounts(accountsId));
            request.setAttribute("accountManagersList", managersDao.findAccountsAllManagers(accountsId));
            System.out.println("accountsId : " + accountsId);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/account/accountDetail.jsp");
            dispatcher.forward(request, response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        AccountsDao accountsDao = new AccountsDao();
        Accounts accounts = new Accounts();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String businessNumber = request.getParameter("businessNumber");
        String businessType = request.getParameter("businessType");
        String businessCategory = request.getParameter("businessCategory");
        String ceo = request.getParameter("ceo");
        String zipcode = request.getParameter("zipcode");
        String address = request.getParameter("address");
        String addressDesc = request.getParameter("addressDesc");
        String phone = request.getParameter("phone");
        String fax = request.getParameter("fax");
        String etc = request.getParameter("etc");

        accounts.setId(id);
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

        System.out.println(accounts.toString());

        if(accountsDao.updateAccounts(accounts)){
            response.sendRedirect("/accounts/Detail.do?id=" + accounts.getId());
            session.setAttribute("successMessage", "거래처 정보가 수정되었습니다.");
        }else {
            response.sendRedirect("/accounts/Detail.do?id=" + accounts.getId());
            session.setAttribute("errorMessage", "거래처 정보 수정이 실패하였습니다.");
        }
    }
}
