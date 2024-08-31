package org.javacore.JDBT_BT;
import org.javacore.Helper.Ultils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocatorSer {
    public List<Locator> findLocatorByName(String name){
        StringBuilder sql = new StringBuilder();
        List<Locator> locators = new ArrayList();
        try{
            Connection con = Ultils.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
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
                locators.add(locator);
            }
        }catch(Exception e){
            e.printStackTrace();

        }
        return locators;

    }
    public List<Locator> timViTriXYZ(){
        StringBuilder sql = new StringBuilder("select * from locator order by x asc , y asc , z asc ;");
        List<Locator> locators = new ArrayList<>();
        try{
            Connection con  = Ultils.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
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
                locators.add(locator);

            }
        }catch(Exception e ){
            e.printStackTrace();
        }
        return locators;


    }
}
