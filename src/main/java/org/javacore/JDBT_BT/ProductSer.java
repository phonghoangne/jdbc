package org.javacore.JDBT_BT;
import org.javacore.Helper.Ultils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ProductSer {
    public  static List<Product> findProductItemOfComBo(int id){
        StringBuilder sql = new StringBuilder("select * from product where product_parent_id = ? and product_type = 'ITEM';");
        List<Product> productItem = new ArrayList<>();
        try{
            Connection con = Ultils.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){

                Product productSer = new Product();
                productSer.setId(rs.getInt("id"));
                productSer.setName(rs.getString("name"));
                productSer.setActive(rs.getString("is_active"));
                productSer.setCreated(rs.getString("created"));
                productSer.setCreateBy(rs.getString("create_by"));
                productSer.setQtyStock(rs.getInt("qty_stock"));
                productSer.setProductType(rs.getString("product_type"));
                productSer.setProductparentId(rs.getInt("product_parent_id"));
                productItem.add(productSer);
            }
        }catch(Exception e ){
            e.printStackTrace();
        }
        return productItem;

    }
    public static List<Product> sapXepSoLuongTonKho(){
        StringBuilder sql = new StringBuilder("select * from product order by qty_stock asc;");
        List<Product> products = new ArrayList<>();
        try{
            Connection con = Ultils.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
            Product productSer = new Product();
            productSer.setId(rs.getInt("id"));
            productSer.setName(rs.getString("name"));
            productSer.setActive(rs.getString("is_active"));
            productSer.setCreated(rs.getString("created"));
            productSer.setCreateBy(rs.getString("create_by"));
            productSer.setQtyStock(rs.getInt("qty_stock"));
            productSer.setProductType(rs.getString("product_type"));
            productSer.setProductparentId(rs.getInt("product_parent_id"));
            products.add(productSer);}

            
        }catch(Exception e){
            e.printStackTrace();
        }
        return products;

    }

}
