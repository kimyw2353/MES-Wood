package com.mes.dao;

import com.mes.manager.DBManager;
import com.mes.model.Managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManagersDao extends DBManager {


    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection conn = null;

    //거래처 관리에서 매니저 등록
    public boolean createAccountsManager(Managers managers) {

        String sql = "INSERT INTO managers(account_id, name, email, phone, position, department, created_at) VALUES (?, ?, ?, ?, ?, ?, now())";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, managers.getAccountId());
            ps.setString(2, managers.getName());
            ps.setString(3, managers.getEmail());
            ps.setString(4, managers.getPhone());
            ps.setString(5, managers.getPosition());
            ps.setString(6, managers.getDepartment());

            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnectionAll(conn, ps, rs);
        }
    }

    //거래처 관리에서 매니저 조회
    public ArrayList<Managers> findAccountsAllManagers(int accountId){

        ArrayList<Managers> AccountManagersList = new ArrayList<>();

        String sql = "SELECT * FROM managers WHERE account_id = ? ";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, accountId);

            rs = ps.executeQuery();

            while (rs.next()){
                Managers managers = new Managers();

                managers.setId(rs.getInt("id"));
                managers.setName(rs.getString("name"));
                managers.setAccountId(rs.getInt("account_id"));
                managers.setEmail(rs.getString("email"));
                managers.setPhone(rs.getString("phone"));
                managers.setPosition(rs.getString("position"));
                managers.setDepartment(rs.getString("department"));

                AccountManagersList.add(managers);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
        return AccountManagersList;
    }

    //거래처 아이디로 매니저 찾기
    public Managers findAccountsByManagerId(int accountId) {

        Managers managers = new Managers();

        String sql = "SELECT * FROM managers WHERE id = ? ";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, accountId);

            rs = ps.executeQuery();

            if (rs.next()) {

                managers.setId(rs.getInt("id"));
                managers.setAccountId(rs.getInt("account_id"));
                managers.setName(rs.getString("name"));
                managers.setEmail(rs.getString("email"));
                managers.setPhone(rs.getString("phone"));
                managers.setPosition(rs.getString("position"));
                managers.setDepartment(rs.getString("department"));

            }
            return managers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeConnectionAll(conn, ps, rs);
        }
    }

    //거래처 관리에서 매니저 수정
    public boolean updateAccountsManagers(Managers managers){
        String sql = "UPDATE managers SET name=?, email=?, phone=?, position=?, department=? WHERE id = ?";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, managers.getName());
            ps.setString(2, managers.getEmail());
            ps.setString(3, managers.getPhone());
            ps.setString(4, managers.getPosition());
            ps.setString(5, managers.getDepartment());
            ps.setInt(6, managers.getId());

            return ps.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("거래처 관리 매니저 수정 불가");
            return false;
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
    }

    //거래처 관리에서 매니저 삭제
    public boolean deleteAccountsManagers(String account_id, int manager_id){
        String sql = "DELETE FROM managers WHERE account_id = ? AND id = ?";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(account_id));
            ps.setInt(2, manager_id);

            return ps.executeUpdate() >= 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("거래처 관리 매니저 삭제 불가");
            return false;
        }finally {
            closeConnectionAll(conn, ps);
        }
    }
    //매니저 토탈 갯수
    public int managersCount(){
        String sql = "SELECT COUNT(*) as count FROM managers WHERE 1=1";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            return (rs.next()) ? rs.getInt("count") : 0;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
    }

    //매니저 리스트 조회
    public ArrayList<Managers> findAllManagers(){
        ArrayList<Managers> list = new ArrayList<>();
        String sql = "SELECT * FROM managers m INNER JOIN accounts a ON m.account_id  = a.id";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Managers managers = new Managers();
                managers.setId(rs.getInt("m.id"));
                managers.setName(rs.getString("m.name"));
                managers.setAccountId(rs.getInt("m.account_id"));
                managers.setAccountName(rs.getString("a.name"));
                managers.setEmail(rs.getString("m.email"));
                managers.setPhone(rs.getString("m.phone"));
                managers.setPosition(rs.getString("m.position"));
                managers.setDepartment(rs.getString("m.department"));

                list.add(managers);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
        return list;
    }

    //매니저 등록
    public boolean createManagers(Managers managers){
        String sql = "INSERT INTO managers(name, account_id, email, phone, position, department, created_at) VALUES (?, ?, ?, ?, ?, ?, now())";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, managers.getName());
            ps.setInt(2, managers.getAccountId());
            ps.setString(3, managers.getEmail());
            ps.setString(4, managers.getPhone());
            ps.setString(5, managers.getPosition());
            ps.setString(6, managers.getDepartment());

            return ps.executeUpdate() >= 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
    }

    //매니저 상세보기
    public Managers findManagers(int managerId){
        Managers managers = new Managers();

        String sql = "SELECT * FROM managers m INNER JOIN accounts a ON m.account_id = a.id WHERE m.id = ?";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, managerId);

            rs = ps.executeQuery();

            if (rs.next()){
                managers.setId(rs.getInt("m.id"));
                managers.setName(rs.getString("m.name"));
                managers.setAccountId(rs.getInt("a.id"));
                managers.setAccountName(rs.getString("a.name"));
                managers.setEmail(rs.getString("m.email"));
                managers.setPhone(rs.getString("m.phone"));
                managers.setPosition(rs.getString("m.position"));
                managers.setDepartment(rs.getString("m.department"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
        return managers;
    }

    //매니저 상세보기 변경
    public boolean updateManagers(Managers managers){
        String sql = "UPDATE managers SET name=?, account_id=?, email=?, phone=?, position=?, department=?, updated_at = now() WHERE id=?";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, managers.getName());
            ps.setInt(2, managers.getAccountId());
            ps.setString(3, managers.getEmail());
            ps.setString(4, managers.getPhone());
            ps.setString(5, managers.getPosition());
            ps.setString(6, managers.getDepartment());
            ps.setInt(7, managers.getId());

            return ps.executeUpdate() >= 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
    }

    //매니저 정보 삭제
    public boolean deleteManagers(int managerId){

        String sql = "DELETE FROM managers WHERE id IN (?)";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, managerId);

            return ps.executeUpdate() >= 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
    }


}


