package com.mes.dao;

import com.mes.manager.DBManager;
import com.mes.model.MaterialsOrders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MaterialsOrdersDao extends DBManager {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection conn = null;


    public ArrayList<MaterialsOrders> findAllMaterialsOrders(){
        ArrayList<MaterialsOrders> materialsOrdersList = new ArrayList<>();
        String sql = "SELECT * FROM materialsorders mo INNER JOIN accounts a ON mo.account_id = a.id WHERE 1=1";

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
                materialsOrders.setOrderDate(rs.getString("mo.orderDate"));
                materialsOrders.setDeadlineDate(rs.getString("mo.deadLindDate"));
                materialsOrders.setEtc(rs.getString("mo.etc"));

                materialsOrdersList.add(materialsOrders);
            }
            return materialsOrdersList;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("materialOrderDao findAllMaterialsOrders Error");
            return null;
        }finally {
            closeConnectionAll(conn, ps, rs);
        }
    }

}
