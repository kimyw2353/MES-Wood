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

    public boolean createMaterialsOrders(MaterialsOrdersDto dto){
        boolean createCheck = false;
        String SQL = "INSERT INTO materialsorders(id, name, account_id, orderDate, etc) VALUES(?, ?, ?, now(), ?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, dto.getId());
            ps.setString(2,dto.getName());
            ps.setInt(3,dto.getAccount_id());
            ps.setString(4, dto.getEtc());

            return ps.executeUpdate() ==1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("materialsOrdersDao createMaterialsOrders() 오류");
        }finally {
            closeConnectionAll(ps, conn);
        }
        return false;
    }

    public int findLastId(){
        int lastId = 0;
//        String SQL = "SELECT LAST_INSERT_ID()";
        String SQL = "show table status where name = 'materialsorders'";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            if(!rs.next()){
                lastId = 10001;
            }else{
                lastId = rs.getInt("Auto_increment");
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

}
