package com.mes.controller.account;

import com.mes.dao.AccountsDao;
import com.mes.model.Accounts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/accounts/Delete.do")
public class AccountDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        AccountsDao accountsDao = new AccountsDao();
        Accounts accounts = new Accounts();

        accounts.setAccountIds(req.getParameterValues("accountIds"));

        ArrayList<Integer> accountLength = new ArrayList<>();

        for (int id : accounts.getAccountIds()){
            if (accountsDao.findManagerByAccountId(id)){ //거래처에 매니저가 등록 되었을 때
                if (accountsDao.deleteAccountManagerByAccountId(id) && accountsDao.deleteAccounts(id)){
                    accountLength.add(id);
                }
            }else { //거래처에 매니저가 없고 단독으로 등록 되어있을 떄
                if (accountsDao.deleteAccounts(id)){
                    accountLength.add(id);
                }
            }
            
        }

        if (accountLength.size() > 0 && accounts.getAccountIds().size() == accountLength.size()){
            session.setAttribute("successMessage", accountLength.size() + " 개의 거래처가 삭제되었습니다.");
            resp.sendRedirect("/account/List.do");
        }else {
            session.setAttribute("errorMessage", "거래처 삭제가 실패하였습니다.");
            resp.sendRedirect("/account/List.do");
        }
    }

}
