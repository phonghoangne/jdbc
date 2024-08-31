package org.javacore.DAO.DAOImpl;

import org.javacore.DAO.CRUD;
import org.javacore.DAO.WarehouseService;
import org.javacore.Helper.Ultils;
import org.javacore.domain.Locator;
import org.javacore.domain.WareHouse;
import org.javacore.domain.Exception.ObjectNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.sql.PreparedStatement;

public class WareHouseImp implements WarehouseService {


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

    @Override
    public List<WareHouse> findByNameLike(String name) {
        StringBuilder sql = new StringBuilder("select * from warehouse where name like % ? % and isActive = ?  ;");
        List<WareHouse> warehouses = new ArrayList<>();
        try{
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1,"%"+name+"%");
            pstmt.setString(2,"Y");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                WareHouse warehouse = new WareHouse();
                warehouse.setId(rs.getInt("id"));
                warehouse.setName(rs.getString("name"));
                warehouse.setActive(rs.getString("is_active"));
                warehouse.setDescription(rs.getString("description"));
                warehouse.setCreateBy(rs.getString("created_by"));
                warehouses.add(warehouse);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return warehouses;
    }

    @Override
    public  List<WareHouse> orderByName(List<WareHouse> list) {

        Collections.sort(list, new Comparator<WareHouse>() {
            @Override
            public int compare(WareHouse o1, WareHouse o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
      return  list;
    }


}
