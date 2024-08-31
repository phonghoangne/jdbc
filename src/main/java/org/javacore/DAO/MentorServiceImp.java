package org.javacore.DAO;

import org.javacore.Helper.Ultils;
import org.javacore.domain.Exception.ObjectNotFoundException;
import org.javacore.domain.Mentor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MentorServiceImp implements Service<Mentor> {
    StringBuilder sql;


    @Override
    public Boolean insert(Mentor mentor) {
        sql = new StringBuilder("insert into mentor(fullname,age,gender ) values(?,?,?);");
        try {
            Connection conn = Ultils.getConnection(); // mo ket noi den sql
            PreparedStatement pstmt = conn.prepareStatement(sql.toString()); // thuc thi cau query
            pstmt.setString(1, mentor.getFullName());
            pstmt.setInt(2, mentor.getAge());
            pstmt.setInt(3, mentor.getGender());
            pstmt.executeUpdate();  // thuc thi cau sql ben tren
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }


    @Override
    public Boolean update(Mentor mentor) {
        sql = new StringBuilder("update mentor set fullname = ?,age=?,gender = ? where mentor_id = ? ;");
        try {
            Connection connection = Ultils.getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, mentor.getFullName());
            pstm.setInt(2, mentor.getAge());
            pstm.setInt(3, mentor.getGender());
            pstm.setInt(4, mentor.getMentorId());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public Boolean deleteById(Integer id) {
        sql = new StringBuilder("delete from mentor where mentor_id = ? ;");
        try {
            Connection conn = Ultils.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setInt(1, id);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new ObjectNotFoundException(" khong tim thay id de delete ");
        }
    }

    @Override
    public Mentor findById(Integer id) {
        sql = new StringBuilder("select mentor_id, fullname,age, gender from mentor where mentor_id = ? ");
        try {
            Mentor mentor = null;
            Connection conn = Ultils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                mentor = new Mentor();
                mentor.setMentorId(rs.getInt("mentor_id"));
                mentor.setFullName(rs.getString("fullname"));
                mentor.setAge(rs.getInt("age"));
                mentor.setGender(rs.getInt("gender"));


            }
            if (mentor != null) {
                return mentor;
            } else {
                throw new ObjectNotFoundException("Khong tim thay mentor");
            }
        } catch (Exception e) {
            throw new ObjectNotFoundException("Khong tim thay mentor");



        }

    }

    @Override
    public List<Mentor> findAll() {
        List<Mentor>  listMentor = new ArrayList<>();
        sql = new StringBuilder("select mentor_id , fullname, age ,gender from mentor");
        try {
            Connection con =  Ultils.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Mentor mentor = new Mentor();
                mentor.setMentorId(rs.getInt("mentor_id"));
                mentor.setFullName(rs.getString("fullname"));
                mentor.setAge(rs.getInt("age"));
                mentor.setGender(rs.getInt("gender"));
                listMentor.add(mentor);

            }
        }catch(Exception e){
            e.printStackTrace();

        }
         return listMentor;
    }
}
