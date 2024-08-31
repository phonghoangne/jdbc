package org.javacore.JDBT_BT;
import org.javacore.Helper.Ultils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WareHouseSer {
    public List<WareHouse> findWareHouseByNameLike(String name){
        StringBuilder sql = new StringBuilder("select * from warehouse where name like ?;");
        List<WareHouse> warehouses = new ArrayList<>();
        try{
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1,name);
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


}
