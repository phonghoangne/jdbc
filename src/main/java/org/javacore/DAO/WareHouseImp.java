package org.javacore.DAO;

import org.javacore.Helper.Ultils;
import org.javacore.JDBT_BT.WareHouse;
import org.javacore.domain.Exception.ObjectNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class WareHouseImp implements CRUD<WareHouse> {


    StringBuilder sql;

    @Override
    public Boolean insert(WareHouse wareHouse) {
        sql = new StringBuilder("insert into warehouse(name, is_active, description, created_by) values (?, ?, ?, ?);");
        try {
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, wareHouse.getName());
            pstmt.setString(2, wareHouse.getIsActive());
            pstmt.setString(3, wareHouse.getDescription());
            pstmt.setString(4, wareHouse.getCreateBy());
            pstmt.executeUpdate();
            return true;


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(WareHouse wareHouse) {
        sql = new StringBuilder("update warehouse set name = ?,is_active = ?,description = ?,created_by = ? where id = ?;");
        try {
            Connection connection = Ultils.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql.toString());
            pstmt.setString(1, wareHouse.getName());
            pstmt.setString(2, wareHouse.getIsActive());
            pstmt.setString(3, wareHouse.getDescription());
            pstmt.setString(4, wareHouse.getCreateBy());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }

    @Override
    public Boolean deleteById(Integer id) {
        sql = new StringBuilder("delete from warehouse where id = ?;");

        try{
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            return true;
        }catch(Exception e){
            throw new  ObjectNotFoundException(" khong tim thay id de delete ");

        }
    }


    @Override
    public List<WareHouse> read() {
        List<WareHouse> listHouse = new ArrayList();
        sql = new StringBuilder("select id,name,is_active,description,created_by from warehouse;");
                try{
                    Connection conn =Ultils.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement(sql.toString());
                    ResultSet rs = pstmt.executeQuery();
                    while(rs.next()){
                        WareHouse wareHouse = new WareHouse();
                        wareHouse.setId(rs.getInt("id"));
                        wareHouse.setName(rs.getString("name"));
                        wareHouse.setActive(rs.getString("is_active"));
                        wareHouse.setDescription(rs.getString("description"));
                        wareHouse.setCreateBy(rs.getString("created_by"));
                        listHouse.add(wareHouse);
                    }
                }catch(Exception e){
                  e.printStackTrace();
                }
                return listHouse;
    }
}
