package com.mes.dao;

import com.mes.manager.DBManager;
import com.mes.model.Accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountsDao extends DBManager {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection conn = null;


    //거래처 토탈 갯수
    public int accountsCount(){
        String sql = "SELECT COUNT(*) as count FROM accounts WHERE 1=1";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            return rs.next() ? rs.getInt("count") : 0;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
    }

    //거래처 리스트 목록
    public ArrayList<Accounts> findAllAccounts(){

        ArrayList<Accounts> list = new ArrayList<>();
        String sql = "SELECT * FROM accounts WHERE 1=1 ORDER BY created_at DESC";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Accounts accounts = new Accounts();
                accounts.setId(rs.getInt("id"));
                accounts.setName(rs.getString("name"));
                accounts.setCeo(rs.getString("ceo"));
                accounts.setPhone(rs.getString("phone"));
                accounts.setEtc(rs.getString("etc"));
                accounts.setCreatedAt(rs.getDate("created_at"));

                list.add(accounts);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
        return list;
    }

    //거래처 등록
    public boolean createAccounts(Accounts accounts){

        String sql = "INSERT INTO accounts(name, businessNumber, businessType, businessCategory, ceo, zipcode, address, addressDesc, phone, fax, etc, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now()) ";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, accounts.getName());
            ps.setString(2, accounts.getBusinessNumber());
            ps.setString(3, accounts.getBusinessType());
            ps.setString(4, accounts.getBusinessCategory());
            ps.setString(5, accounts.getCeo());
            ps.setString(6, accounts.getZipcode());
            ps.setString(7, accounts.getAddress());
            ps.setString(8, accounts.getAddressDesc());
            ps.setString(9, accounts.getPhone());
            ps.setString(10, accounts.getFax());
            ps.setString(11, accounts.getEtc());

            return ps.executeUpdate() == 1;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
    }

    //거래처 선택 출력
    public Accounts selectAccounts(int id){
        Accounts accounts = new Accounts();

        String sql = "SELECT * FROM accounts WHERE id = ?";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                accounts.setId(rs.getInt("id"));
                accounts.setName(rs.getString("name"));
                accounts.setBusinessNumber(rs.getString("businessNumber"));
                accounts.setBusinessType(rs.getString("businessType"));
                accounts.setBusinessCategory(rs.getString("businessCategory"));
                accounts.setCeo(rs.getString("ceo"));
                accounts.setZipcode(rs.getString("zipcode"));
                accounts.setAddress(rs.getString("address"));
                accounts.setAddressDesc(rs.getString("addressDesc"));
                accounts.setPhone(rs.getString("phone"));
                accounts.setFax(rs.getString("fax"));
                accounts.setEtc(rs.getString("etc"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
        return accounts;
    }

    //거래처 수정
    public boolean updateAccounts(Accounts accounts){
        String sql = "UPDATE accounts SET name=?, businessNumber=?, businessType=?, businessCategory=?, ceo=?, zipcode=?, address=?, addressDesc=?, phone=?, fax=?, etc=?, updated_at = now() WHERE id=?";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, accounts.getName());
            ps.setString(2, accounts.getBusinessNumber());
            ps.setString(3, accounts.getBusinessType());
            ps.setString(4, accounts.getBusinessCategory());
            ps.setString(5, accounts.getCeo());
            ps.setString(6, accounts.getZipcode());
            ps.setString(7, accounts.getAddress());
            ps.setString(8, accounts.getAddressDesc());
            ps.setString(9, accounts.getPhone());
            ps.setString(10, accounts.getFax());
            ps.setString(11, accounts.getEtc());
            ps.setInt(12, accounts.getId());

            return ps.executeUpdate() == 1;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
    }

    //거래처 삭제
    public boolean deleteAccounts(int accountId){
        String sql = "DELETE FROM accounts WHERE id = ?";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, accountId);
            ps.executeUpdate();

            return ps.executeUpdate() >= 0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
    }

    //거래처 아이디 매니저 찾기
    public boolean findManagerByAccountId(int accountId){
        String sql = "SELECT * FROM managers WHERE account_id = ?";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, accountId);

            return ps.executeQuery().next();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
    }

    //거래처에 매니저 있을 때 전체 삭제
    public boolean deleteAccountManagerByAccountId(int accountId){
        String sql = "DELETE FROM managers WHERE account_id = ? ";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, accountId);

            return ps.executeUpdate() >= 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
    }



}
