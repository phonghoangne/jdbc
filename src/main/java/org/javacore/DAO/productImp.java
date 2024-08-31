package org.javacore.DAO;

import org.javacore.Helper.Ultils;
import org.javacore.JDBT_BT.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
public class productImp implements CRUD<Product> {
    StringBuilder sql;
    @Override
    public Boolean insert(Product product) {
        sql = new StringBuilder("insert into product(name,is_active,created, create_by, qty_stock, product_type, product_parent_id) values (?, ?, ?, ?, ?, ?, ?);");
        try{
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql.toString());
            pstmt.setString(1,product.getName());
            pstmt.setString(2,product.isActive());
            pstmt.setString(3,product.getCreated());
            pstmt.setString(4,product.getCreateBy());
            pstmt.setInt(5,product.getQtyStock());
            pstmt.setString(6,product.getProductType());
            pstmt.setInt(7,product.getProductparentId());
            pstmt.executeUpdate();
            return true;


        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Boolean update(Product product) {
        sql = new StringBuilder("update product set name = ?, is_active = ?, created = ?, create_by = ?, qty_stock = ?, product_type = ?, product_parent_id = ? WHERE id = ?; ");
        try{
            Connection con = Ultils.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1,product.getName());
            pstmt.setString(2,product.isActive());
            pstmt.setString(3,product.getCreated());
            pstmt.setString(4,product.getCreateBy());
            pstmt.setInt(5,product.getQtyStock());
            pstmt.setString(6,product.getProductType());
            pstmt.setInt(7,product.getProductparentId());
            pstmt.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteById(Integer id) {
        sql = new StringBuilder("delete from product where  id = ?;");
        try{
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        return false;}
    }

    @Override
    public List<Product> read() {
        List<Product> products = new ArrayList<>();
        sql = new StringBuilder("Select * from product;");
        try{
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Product product1 = new Product();
                product1.setId(rs.getInt("id"));
                product1.setName(rs.getString("name"));
                product1.setActive(rs.getString("is_active"));
                product1.setCreated(rs.getString("created"));
                product1.setCreateBy(rs.getString("create_by"));
                product1.setQtyStock(rs.getInt("qty_stock"));
                product1.setProductType(rs.getString("product_type"));
                product1.setProductparentId(rs.getInt("product_parent_id"));
                products.add(product1);

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return products;
    }


}
