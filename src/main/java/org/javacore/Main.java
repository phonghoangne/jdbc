package org.javacore;

import org.javacore.DAO.*;
import org.javacore.Helper.Ultils;
import org.javacore.JDBT_BT.Locator;
import org.javacore.JDBT_BT.Product;
import org.javacore.JDBT_BT.ProductSer;
import org.javacore.JDBT_BT.WareHouse;
import org.javacore.domain.Mentor;
import org.javacore.domain.StudentUDPM;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Product> sortedProducts = ProductSer.sapXepSoLuongTonKho();
        List<Product> timIt = ProductSer.findProductItemOfComBo(1);
        for (Product product : timIt) {
            System.out.println("ID: " + product.getId() +
                    ", Tên: " + product.getName() +
                    ", Số lượng tồn kho: " + product.getQtyStock() +
                    ", Kích hoạt: " + product.getIsActive() +
                    ", Ngày tạo: " + product.getCreated() +
                    ", Người tạo: " + product.getCreateBy() +
                    ", Loại sản phẩm: " + product.getProductType() +
                    ", ID sản phẩm cha: " + product.getProductparentId());
        }

//        for (Product product : sortedProducts) {
//            System.out.println("ID: " + product.getId() +
//                    ", Tên: " + product.getName() +
//                    ", Số lượng tồn kho: " + product.getQtyStock() +
//                    ", Kích hoạt: " + product.getIsActive() +
//                    ", Ngày tạo: " + product.getCreated() +
//                    ", Người tạo: " + product.getCreateBy() +
//                    ", Loại sản phẩm: " + product.getProductType() +
//                    ", ID sản phẩm cha: " + product.getProductparentId());
//        }
    }
//        Service<Mentor> service = new MentorServiceImp();
//        List<Mentor> listMentor = service.findAll();
//        for(Mentor item : listMentor){
//            System.out.println(item.toString());
//        }
//        Mentor mentorInsert = new Mentor(0,"Hoang Van Phong",23,0);
//        service.insert(mentorInsert);
//        listMentor = service.findAll();
//        for (Mentor item : listMentor){
//            System.out.println(item.toString());
//        }

//        CRUD<Locator> crudLoca = new LocatorImp();
//        List<Locator> listLoca = crudLoca.read();
//        Locator locaInsert = new Locator(0,"Hoang Van Phong", "1",2,3,4, "30/8", "chithanh", 1);
//        crudLoca.insert(locaInsert);
//
//        for (Locator item : listLoca) {
//            System.out.println(item);
//        }

//        CRUD<WareHouse> crudW = new WareHouseImp();
//        List<WareHouse> listH = crudW.read();
//        for (WareHouse item : listH) {
//            System.out.println(item);
//        }
//
//        WareHouse houseInsert = new WareHouse(0, "Hoang Van Loc", "1", "description 2", "admin", "Y");
//        crudW.insert(houseInsert);
//
//        for (WareHouse item : listH) {
//            System.out.println(item);
//        }
        // insert cho product
//        CRUD<Product> crudPro = new productImp();
//        List<Product> productList = crudPro.read();
//        for(Product item : productList){
//            System.out.println(item);
////        }




//        Product productInsert = new Product(0,"Product3","Y","1","admin",1,"ITEM",3);
//        crudPro.insert(productInsert);
//        for(Product item : productList){
//            System.out.println(item);
//        }

//         Service<StudentUDPM>  udpmSevice = new StudentUDPMImpl();
//        List<StudentUDPM> chithanh = udpmSevice.findAll();
//        StudentUDPM phong = udpmSevice.findById(1);
//
//        // ham tra ve kieu listStudent nen can tra ve kieu cua listStudent
////        for(StudentUDPM i : listUdpm){
////            System.out.println(i.toString());
////        }
//        StudentUDPM  studentUdpma = udpmSevice.findById(4);
//        System.out.println(studentUdpma);

//        StringBuilder sql = new StringBuilder("select mentor_id,fullname, age, gender from mentor; ");
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        PreparedStatement pstmt = null;
//    try{
//        conn  = Ultils.getConnection(); // connection dang ket noi
//        stmt = conn.createStatement(); // tao statement
//      rs =   stmt.executeQuery(sql.toString()); // chay cau query
////        while(rs.next()){
////            System.out.println("mentor  id :" + rs.getInt("mentor_id"));
////            System.out.println("mentor Name : "+ rs.getString("fullname"));
////            System.out.println("mentor age : "+ rs.getInt("age"));
////            if(rs.getInt("gender")== 0) {
////                System.out.println("gender : Nam");
////            }else{
////                System.out.println("gender : Nu");
////            }
////        }
////
////        System.out.println("------------");
////        sql = new StringBuilder("select mentor_id,fullname, age, gender from mentor where mentor_id in (? , ?); ");
////        Scanner sc = new Scanner(System.in);
////        System.out.println("nhap id thu nhat : ");
////        int id1 = sc.nextInt();
////        System.out.println("nhap id thu hai : ");
////        int id2 = sc.nextInt();
////        pstmt = conn.prepareStatement(sql.toString());
////        pstmt.setInt(1,id1);
////        pstmt.setInt(2,id2);
////        rs = pstmt.executeQuery();
////        while(rs.next()){
////            System.out.println("mentor  id :" + rs.getInt("mentor_id"));
////            System.out.println("mentor Name : "+ rs.getString("fullname"));
////            System.out.println("mentor age : "+ rs.getInt("age"));
////            if(rs.getInt("gender")== 0) {
////                System.out.println("gender : Nam");
////            }else{
////                System.out.println("gender : Nu");
////            }
////        }
////        System.out.println("------------");
////        // lay tat ca thong tin students.
////         sql = new StringBuilder("select student_id,fullname,age,major from students;");
////        conn  = Ultils.getConnection(); // connection dang ket noi
////        stmt = conn.createStatement(); // tao statement
////        rs =   stmt.executeQuery(sql.toString()); // chay cau query
////        while(rs.next()) {
////            System.out.println("student  id :" + rs.getInt("student_id"));
////            System.out.println("student Name : " + rs.getString("fullname"));
////            System.out.println("student age : " + rs.getInt("age"));
////            System.out.println("student age : " + rs.getString("major"));
////        }
////        System.out.println("------------");
////        // lay thong tin student theo nghanh
////        sql = new StringBuilder("select * from students where major = 'DATA';");
////        conn  = Ultils.getConnection(); // connection dang ket noi
////        stmt = conn.createStatement(); // tao statement
////        rs =   stmt.executeQuery(sql.toString()); // chay cau query
////        while(rs.next()) {
////            System.out.println("student  id :" + rs.getInt("student_id"));
////            System.out.println("student Name : " + rs.getString("fullname"));
////            System.out.println("student age : " + rs.getInt("age"));
////            System.out.println("student age : " + rs.getString("major"));
////        }
////        System.out.println("------------");
////
////        sql = new StringBuilder("select * from students where major = 'UDPM';");
////        conn  = Ultils.getConnection(); // connection dang ket noi
////        stmt = conn.createStatement(); // tao statement
////        rs =   stmt.executeQuery(sql.toString()); // chay cau query
////        while(rs.next()) {
////            System.out.println("student  id :" + rs.getInt("student_id"));
////            System.out.println("student Name : " + rs.getString("fullname"));
////            System.out.println("student age : " + rs.getInt("age"));
////            System.out.println("student age : " + rs.getString("major"));
////        }
//        Scanner sc = new Scanner(System.in);
//        System.out.println("------------------------------------");
//        // lay thong tin student theo name
//        System.out.println("Hãy nhạp tên nhân viên cần tìm : " );
//        String name = sc.nextLine();
//        sql = new StringBuilder("select * from students where fullname like ?;");
//
//        pstmt = conn.prepareStatement(sql.toString());
//         pstmt.setString(1,"%"+name+"%");
//        rs = pstmt.executeQuery();
//        while(rs.next()) {
//            System.out.println("student  id :" + rs.getInt("student_id"));
//            System.out.println("student Name : " + rs.getString("fullname"));
//            System.out.println("student age : " + rs.getInt("age"));
//            System.out.println("student age : " + rs.getString("major"));
//            System.out.println();
//        }
//
//
//
//
//
//
//    }catch(Exception e){
//        e.printStackTrace();
//        }finally{
//        Ultils.close(conn);
//    }
    }
