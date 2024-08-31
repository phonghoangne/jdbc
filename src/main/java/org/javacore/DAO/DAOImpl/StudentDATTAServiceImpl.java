package org.javacore.DAO.DAOImpl;

import org.javacore.DAO.Service;
import org.javacore.Helper.Ultils;
import org.javacore.domain.Exception.ObjectNotFoundException;
import org.javacore.domain.StudentDATA;


import javax.swing.text.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDATTAServiceImpl implements Service<StudentDATA> {
    StringBuilder sql;

    @Override
    public Boolean insert(StudentDATA StudentData) {
        sql = new StringBuilder("select student_id,fullname,age,major,point_orade,point_mysql,point_posgresql; ) values(?,?,?,?,?,?) ;");
        try {
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, StudentData.getFullName());
            pstmt.setInt(2, StudentData.getAge());
            pstmt.setString(3, StudentData.getMajor());
            pstmt.setDouble(4, StudentData.getPointOracle());
            pstmt.setDouble(5, StudentData.getPointMysql());
            pstmt.setDouble(6, StudentData.getPointPosgresql());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(StudentDATA StudentData) {
        sql = new StringBuilder("update students set fullname = ?,age=?,gender = ? where major = 'DATA' and student_id = ? ;");
        try {
            Connection connection = Ultils.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql.toString());
            pstmt.setString(1, StudentData.getFullName());
            pstmt.setInt(2, StudentData.getAge());
            pstmt.setDouble(3, StudentData.getPointOracle());
            pstmt.setDouble(4, StudentData.getPointMysql());
            pstmt.setDouble(5, StudentData.getPointPosgresql());
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
    public StudentDATA findById(Integer id) {
        sql = new StringBuilder("select student_id,fullname,age,major,point_orade,point_mysql,point_posgresql from students where student_id = ?;");
        try{
            StudentDATA StudentData = null;
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.getResultSet();
            while(rs.next()){
                StudentData = new StudentDATA();
                StudentData.setStudentId(rs.getInt("student_id"));
                StudentData.setFullName(rs.getString("fullname"));
                StudentData.setAge(rs.getInt("age"));
                StudentData.setPointOracle(rs.getDouble("point_orade"));
                StudentData.setPointMysql(rs.getDouble("point_mysql"));
                StudentData.setPointPosgresql(rs.getDouble("point_posgresql"));

            }
            if(StudentData != null){
                return StudentData;
            }else {
                throw new ObjectNotFoundException("Khong tim thay student");

            }
        }catch(Exception e){
            throw new ObjectNotFoundException("Khong tim thay student");

        }
}
    @Override
    public List<StudentDATA> findAll() {
        List<StudentDATA> listData = new ArrayList();
        sql = new StringBuilder("select student_id,fullname,age,major,point_java1,point_web,point_java2 from students;");
        try{
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            ResultSet rs = pstmt.getResultSet();
            while(rs.next()){
                StudentDATA   studentData = new StudentDATA();
                studentData.setStudentId(rs.getInt("student_id"));
                studentData.setFullName(rs.getString("fullname"));
                studentData.setAge(rs.getInt("age"));
                studentData.setPointOracle(rs.getDouble("point_orade"));
                studentData.setPointMysql(rs.getDouble("point_mysql"));
                studentData.setPointPosgresql(rs.getDouble("point_posgresql"));
                listData.add(studentData);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listData;
    }

    }

