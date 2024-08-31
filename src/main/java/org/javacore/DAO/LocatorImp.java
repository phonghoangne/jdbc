package org.javacore.DAO;

import org.javacore.Helper.Ultils;
import org.javacore.JDBT_BT.Locator;
import org.javacore.domain.Exception.ObjectNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocatorImp implements CRUD<Locator> {
    StringBuilder sql;

    @Override
    public Boolean insert(Locator locator) {
        sql = new StringBuilder("insert into locator(name, is_active,x,y,z ,creatd, created_by,warehouse_id) values (?, ?, ?, ?,?, ?, ?, ?);");

        try {
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, locator.getName());
            pstmt.setString(2, locator.getIsActive());
            pstmt.setInt(3, locator.getX());
            pstmt.setInt(4, locator.getY());
            pstmt.setInt(5, locator.getZ());
            pstmt.setString(6, locator.getCreated());
            pstmt.setString(7, locator.getCreateBy());
            pstmt.setInt(8, locator.getWareHouseId());

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }

    @Override
    public Boolean update(Locator locator) {
        sql = new StringBuilder("update locator set name = ?, is_active= ?,x= ?,y= ?,z= ? ,creatd= ?, created_by= ?,warehouse_id= ? where id = ?;");
        try {
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, locator.getName());
            pstmt.setString(2, locator.getIsActive());
            pstmt.setInt(3, locator.getX());
            pstmt.setInt(4, locator.getY());
            pstmt.setInt(5, locator.getZ());
            pstmt.setString(6, locator.getCreated());
            pstmt.setString(7, locator.getCreateBy());
            pstmt.setInt(8, locator.getWareHouseId());

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }

    @Override
    public Boolean deleteById(Integer id) {
        sql = new StringBuilder("delete from locator where id = ?;");
        try {
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new ObjectNotFoundException(" khong tim thay id de delete ");

        }
    }


    @Override
    public List<Locator> read() {
        List<Locator> listLoca = new ArrayList();
        sql = new StringBuilder("select id,name, is_active,x,y,z ,creatd, created_by,warehouse_id from locator;");
        try {
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Locator locator = new Locator();
                locator.setId(rs.getInt("id"));
                locator.setName(rs.getString("name"));
                locator.setIsActive(rs.getString("is_active"));
                locator.setX(rs.getInt("x"));
                locator.setY(rs.getInt("y"));
                locator.setZ(rs.getInt("z"));
                locator.setCreated(rs.getString("creatd"));
                locator.setCreateBy(rs.getString("created_by"));
                locator.setWareHouseId(rs.getInt("warehouse_id"));
                listLoca.add(locator);

            }
        } catch (Exception e
        ) {
            e.printStackTrace();
        }
        return listLoca;
    }

}
