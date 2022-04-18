package com.mes.manager;

import java.sql.*;

public class DBManager {
    public static Connection getConnection(){
        try{
            String url = "jdbc:mysql://175.210.112.200:3006/mes_wood?serverTimezone=UTC";
            String id = "bizplus";
            String pw = "bizplus";
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, id, pw);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void close(ResultSet rs, PreparedStatement ps , Connection conn){
        if( ps != null) try{ rs.close();} catch (Exception e){};
        if( ps != null) try{ ps.close();} catch (Exception e){};
        if( ps != null) try{ conn.close();} catch (Exception e){};
    }

    //개별 확인
    public boolean findById(String tableName, int id) {
        Connection conn = this.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM " + tableName + " where id = " + id);
            return ps.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            this.closeConnectionAll(ps, conn);
        }
    }

    //일괄 확인
    public int findCountByIds(String tableName, String ids) {
        Connection conn = this.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) as count FROM " + tableName + " where id in " + "(" + ids + ")";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs.next() ? rs.getInt("count") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.closeConnectionAll(rs, ps, conn);
        }
    }

    public void closeConnectionAll(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnectionAll(PreparedStatement ps, Connection conn) {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
