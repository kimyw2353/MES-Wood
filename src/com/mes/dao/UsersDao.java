package com.mes.dao;

import com.mes.cryptographic.MD5;
import com.mes.manager.DBManager;
import com.mes.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsersDao extends DBManager {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection conn = null;

    public int findUserByUserId(String userId){
        String sql = "SELECT * FROM users WHERE user_id = ?";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) return 1;
            else return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 2;
        }finally {
            closeConnectionAll(rs, ps, conn);
        }
    }

    //회원 확인
    public Users findByUserId(String userId){
        Users users = new Users();

        String sql = "SELECT * FROM users WHERE user_id = ?";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.executeQuery();

            rs = ps.executeQuery();
            if (rs.next()){
                users.setId(rs.getInt("id"));
                users.setUserId(rs.getString("user_id"));
                users.setPassword(rs.getString("password"));
                users.setName(rs.getString("name"));
                return users;
            }else return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            closeConnectionAll(rs, ps, conn);
        }
    }

    //회원가입
    public boolean createUsers(Users users){

        String sql = "INSERT INTO users(user_id, password, name, created_at) VALUES(?,?,?,now())";

        MD5 md5 = new MD5();
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, users.getUserId());
            ps.setString(2, md5.encoding(users.getPassword()));
            ps.setString(3, users.getName());
            ps.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnectionAll(ps, conn);
        }

    }

}
