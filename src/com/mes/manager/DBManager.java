package com.mes.manager;

import java.sql.*;

public class DBManager {

    public Connection getConnection() {
        try {
            String url = "jdbc:mysql://175.210.112.200:3006/mes_wood?serverTimezone=UTC";
            String id = "bizplus";
            String pw = "bizplus";
            /*String url = "jdbc:mysql://localhost:3306/mes_test?serverTimezone=UTC";
            String id = "root";
            String pw = "root";*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, id, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //개별 확인
    public boolean findById(String tableName, int id) {
        Connection conn = this.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM " + tableName + " where id = " + id);
            return (ps.executeQuery().next()) ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            this.closeConnectionAll(conn, ps);
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
            this.closeConnectionAll(conn, ps, rs);
        }
    }

    public void closeConnectionAll(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (conn != null) conn.close();
            if (ps != null) ps.close();
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnectionAll(Connection conn, PreparedStatement ps) {
        try {
            if (conn != null) conn.close();
            if (ps != null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
