package com.mes.dao;

import com.mes.dto.MaterialsOrdersDto;
import com.mes.manager.DBManager;
import com.mes.model.MaterialsOrders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialsOrdersDao extends DBManager {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection conn = null;
    int result;

    //자재발주 토탈 갯수
    public int MaterialordersCount(){
        String sql = "SELECT COUNT(*) FROM materialsorder WHERE 1=1";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            return rs.next() ? rs.getInt(1) : 0;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            closeConnectionAll(rs, ps, conn);
        }
    }

    public boolean createMaterialsOrders(MaterialsOrdersDto dto){
        boolean createCheck = false;
        String SQL;
        System.out.println("orderDate = " + dto.getOrderDate());
        if(dto.getOrderDate()=="default"){
            SQL = "INSERT INTO materialsorders(name, number, account_id, orderDate, etc) VALUES(?, ?, ?, DEFAULT, ?)";
            try {
                conn = getConnection();
                ps = conn.prepareStatement(SQL);
                ps.setString(1,dto.getName());
                ps.setString(2, dto.getNumber());
                ps.setInt(3,dto.getAccount_id());
                ps.setString(4, dto.getEtc());

                System.out.println(SQL);

                return ps.executeUpdate() ==1;
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("materialsOrdersDao createMaterialsOrders() 오류");
            }finally {
                closeConnectionAll(ps, conn);
            }
        }else{
            SQL = "INSERT INTO materialsorders(name, number, account_id, orderDate, etc) VALUES(?, ?, ?, ?, ?)";
            try {
                conn = getConnection();
                ps = conn.prepareStatement(SQL);
                ps.setString(1,dto.getName());
                ps.setString(2, dto.getNumber());
                ps.setInt(3,dto.getAccount_id());
                ps.setString(4, dto.getOrderDate());
                ps.setString(5, dto.getEtc());

                System.out.println(SQL);
                return ps.executeUpdate() ==1;
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("materialsOrdersDao createMaterialsOrders() 오류");
            }finally {
                closeConnectionAll(ps, conn);
            }
        }

        return false;
    }

    public int findLastId(){
        int lastId = 0;
//        String SQL = "SELECT LAST_INSERT_ID()";
//        String SQL = "show table status where name = 'materialsorders'";
        String SQL = "SELECT MAX(`number`) AS 'number' FROM materialsorders";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            if(!rs.next()){
                lastId = 10001;
            }else{
                lastId = rs.getInt(1);
                System.out.println(lastId);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnectionAll(rs, ps, conn);
        }
        return lastId;

    }


    public ArrayList<MaterialsOrders> findAllMaterialsOrders(){
        ArrayList<MaterialsOrders> materialsOrdersList = new ArrayList<>();
        String sql = "SELECT * FROM materialsorders mo INNER JOIN accounts a ON mo.account_id = a.id";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                MaterialsOrders materialsOrders = new MaterialsOrders();
                materialsOrders.setId(rs.getInt("mo.id"));
                materialsOrders.setName(rs.getString("mo.name"));
                materialsOrders.setNumber(rs.getString("mo.number"));
                materialsOrders.setAccountName(rs.getString("a.name"));
                materialsOrders.setPrice(rs.getInt("mo.price"));
                materialsOrders.setOrderDate(rs.getDate("mo.orderDate"));
                materialsOrders.setDeadlineDate(rs.getDate("mo.deadlineDate"));
                materialsOrders.setEtc(rs.getString("mo.etc"));

                materialsOrdersList.add(materialsOrders);
            }
            return materialsOrdersList;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("materialOrderDao findAllMaterialsOrders Error");
            return null;
        }finally {
            closeConnectionAll(rs, ps, conn);
        }
    }

    public MaterialsOrdersDto selectMaterialsOrder(int m_orderId) {
        MaterialsOrdersDto dto = new MaterialsOrdersDto();
        String SQL = "SELECT m.id, m.name, m.number, a.name, m.price, m.orderDate, m.etc\n" +
                "FROM materialsorders m INNER JOIN accounts a ON m.account_id = a.id\n" +
                "WHERE m.id =?";
        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, m_orderId);
            rs = ps.executeQuery();

            if(rs.next()){
                dto.setId(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setNumber(rs.getString(3));
                dto.setAccount_name(rs.getString(4));
                dto.setPrice(rs.getInt(5));
                dto.setOrderDate(String.valueOf(rs.getDate(6)));
                dto.setEtc(rs.getString(7));

                return dto;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return dto;

    }
}
