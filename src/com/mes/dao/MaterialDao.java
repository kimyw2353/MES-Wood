package com.mes.dao;

import com.mes.manager.DBManager;
import com.mes.model.Materials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MaterialDao extends DBManager {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection conn = null;

    //자재 관리 토탈 개수
    public int materialsCount(){
        String sql = "SELECT COUNT(*) AS count FROM materials WHERE 1=1";
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            return rs.next() ? rs.getInt("count") : 0;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("materialDao materialCount 오류");
            return 0;
        }finally {
            closeConnectionAll(rs, ps, conn);
        }
    }



    //자재 관리 리스트 조회
    public ArrayList<Materials> findAllMaterials(){

        ArrayList<Materials> materialsArrayList = new ArrayList<>();

        String sql = "SELECT * FROM materials m INNER JOIN accounts a ON m.account_id = a.id WHERE 1=1 ORDER BY m.created_at DESC";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Materials materials = new Materials();

                materials.setId(Integer.parseInt(rs.getString("id")));
                materials.setCode(rs.getString("code"));
                materials.setName(rs.getString("m.name")); //자재명
                materials.setAccountName(rs.getString("a.name")); //거래처명
                materials.setHeight(rs.getString("height"));
                materials.setWidth(rs.getString("width"));
                materials.setEtc(rs.getString("etc"));

                materialsArrayList.add(materials);
                System.out.println("materials : "+materials.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("materialDao findAllMaterials 오류 ");
        }finally {
            closeConnectionAll(rs, ps, conn);
        }
        return materialsArrayList;
    }

    
    //자재 생성
    public boolean createMaterials(Materials materials){

        String sql = "INSERT INTO materials(code, name, account_id, height, width, etc, created_at) VALUES (?, ?, ?, ?, ?, ?, now())";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, materials.getCode());
            ps.setString(2, materials.getName());
            ps.setInt(3, materials.getAccountId());
            ps.setString(4, materials.getHeight());
            ps.setString(5, materials.getWidth());
            ps.setString(6, materials.getEtc());
            
            return ps.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("materialDao createMaterials 오류");
            return false;
        }finally {
            closeConnectionAll(rs, ps, conn);
        }
    }

    //자재 아이디로 자재 찾기
    public Materials findMaterials(int materialsId){
        Materials materials = new Materials();

        String sql = "SELECT * FROM materials m INNER JOIN accounts a ON m.account_id = a.id WHERE m.id = ?";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, materialsId);

            rs = ps.executeQuery();

            if (rs.next()){
                materials.setId(rs.getInt("m.id"));
                materials.setName(rs.getString("m.name"));
                materials.setCode(rs.getString("m.code"));
                materials.setAccountId(rs.getInt("m.account_id"));
                materials.setAccountName(rs.getString("a.name"));
                materials.setHeight(rs.getString("m.height"));
                materials.setWidth(rs.getString("m.width"));
                materials.setEtc(rs.getString("m.etc"));
            }
            return materials;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("materialDao findMaterials 오류");
            return null;
        }finally {
            closeConnectionAll(rs, ps, conn);
        }
    }

    //자재 정보 변경
    public boolean updateMaterials(Materials materials){

        String sql = "UPDATE materials SET code=?, name=?, account_id=?, height=?, width=?, etc=?, updated_at = now() WHERE id = ?";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, materials.getCode());
            ps.setString(2, materials.getName());
            ps.setInt(3, materials.getAccountId());
            ps.setString(4, materials.getHeight());
            ps.setString(5, materials.getWidth());
            ps.setString(6, materials.getEtc());

            ps.setInt(7, materials.getId());

            return ps.executeUpdate() >= 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("materialDao updateMaterials 오류");
            return false;
        }finally {
            closeConnectionAll(rs, ps, conn);
        }
    }

    //자재 정보 삭제
    public boolean deleteMaterials(int materialId){
        String sql = "DELETE FROM materials WHERE id IN (?)";

        try{
            conn = getConnection();

            ps = conn.prepareStatement(sql);

            ps.setInt(1, materialId);

            return ps.executeUpdate() >= 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("materialDao deleteMaterials 오류");
            return false;
        }finally {
            closeConnectionAll(rs, ps, conn);
        }
    }


}
