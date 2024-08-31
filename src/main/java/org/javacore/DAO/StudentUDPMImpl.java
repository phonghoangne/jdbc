package org.javacore.DAO;

import org.javacore.Helper.Ultils;
import org.javacore.domain.Exception.ObjectNotFoundException;
import org.javacore.domain.StudentUDPM;

import javax.swing.text.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentUDPMImpl implements Service<StudentUDPM> {
    StringBuilder sql;

    @Override
    public Boolean insert(StudentUDPM studentUDPM) {
        sql = new StringBuilder("insert into students(fullname,age,major,point_java1,point_web,point_java2 ) values(?,?,?,?,?,?) ;");
        try {
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, studentUDPM.getFullName());
            pstmt.setInt(2, studentUDPM.getAge());
            pstmt.setString(3,studentUDPM.getMajor());
            pstmt.setDouble(4, studentUDPM.getPointJava1());
            pstmt.setDouble(5, studentUDPM.getPointJava2());
            pstmt.setDouble(6, studentUDPM.getPointJava3());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(StudentUDPM studentUDPM) {
        sql = new StringBuilder("update students set fullname = ?,age=?,gender = ? where major = 'UDPM' and student_id = ? ;");
        try {
            Connection connection = Ultils.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql.toString());
            pstmt.setString(1, studentUDPM.getFullName());
            pstmt.setInt(2, studentUDPM.getAge());
            pstmt.setDouble(3, studentUDPM.getPointJava1());
            pstmt.setDouble(4, studentUDPM.getPointJava2());
            pstmt.setDouble(5, studentUDPM.getPointJava3());
            pstmt.executeUpdate();
            return true;


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Boolean deleteById(Integer id) {
        sql = new StringBuilder("delete from students where student_id = ? ;");
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
    public StudentUDPM findById(Integer id) {
        sql = new StringBuilder("select student_id,fullname,age,major,point_java1,point_web,point_java2 from students where student_id = ?;");
        try{
            StudentUDPM studentUdpm = null;
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                studentUdpm = new StudentUDPM();
                studentUdpm.setStudentId(rs.getInt("student_id"));
                studentUdpm.setFullName(rs.getString("fullname"));
                studentUdpm.setAge(rs.getInt("age"));
                studentUdpm.setPointJava1(rs.getDouble("point_java1"));
                studentUdpm.setPointJava2(rs.getDouble("point_web"));
                studentUdpm.setPointJava3(rs.getDouble("point_java2"));

            }
            if(studentUdpm != null){
                return studentUdpm;
            }else {
                throw new ObjectNotFoundException("Khong tim thay student");

            }
        }catch(Exception e){
            throw new ObjectNotFoundException("Khong tim thay student");

        }

    }

    @Override
    public List<StudentUDPM> findAll() {
        List<StudentUDPM> listUdpm = new ArrayList();
        sql = new StringBuilder("select student_id,fullname,age,major,point_java1,point_web,point_java2 from students where major = 'UDPM' ;");
        try{
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                StudentUDPM    studentUdpm = new StudentUDPM();
                studentUdpm.setStudentId(rs.getInt("student_id"));
                studentUdpm.setFullName(rs.getString("fullname"));
                studentUdpm.setMajor(rs.getString("major"));
                studentUdpm.setAge(rs.getInt("age"));
                studentUdpm.setPointJava1(rs.getDouble("point_java1"));
                studentUdpm.setPointJava2(rs.getDouble("point_web"));
                studentUdpm.setPointJava3(rs.getDouble("point_java2"));
                listUdpm.add(studentUdpm);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listUdpm;
    }
}
