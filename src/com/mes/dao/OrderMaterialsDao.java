package com.mes.dao;

import com.mes.dto.OrderMaterialsDto;
import com.mes.manager.DBManager;
import com.mes.model.Materials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderMaterialsDao extends DBManager {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<OrderMaterialsDto> findMaterialsByOrderId(int orderId){
        ArrayList<OrderMaterialsDto> list = new ArrayList<>();

        String SQL = "SELECT o.id, m.code , m.name, m.height, m.width, o.amount, o.price, o.materials_id, o.order_id  \n" +
                "FROM ordermaterials o INNER JOIN materials m ON o.materials_id = m.id WHERE o.order_id = ?";
        try{
            conn = getConnection();
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()){
                OrderMaterialsDto dto = new OrderMaterialsDto();
                dto.setId(rs.getInt(1));
                dto.setCode(rs.getString(2));
                dto.setName(rs.getString(3));
                dto.setHeight(rs.getInt(4));
                dto.setWidth(rs.getInt(5));
                dto.setAmount(rs.getInt(6));
                dto.setPrice(rs.getInt(7));
                list.add(dto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnectionAll(rs, ps, conn);
        }
        return list;


    }

    //발주 자재 추가
    public boolean createOrderMaterials(int amount, int price, int materials_id, int order_id){
        String SQL = "INSERT INTO ordermaterials (amount , price, materials_id, order_id) values (?,?,?,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, amount);
            ps.setInt(2, price);
            ps.setInt(3, materials_id);
            ps.setInt(4, order_id);

            int result = ps.executeUpdate();
            if(result > 0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnectionAll(ps, conn);
        }
        return false;

    }
}
