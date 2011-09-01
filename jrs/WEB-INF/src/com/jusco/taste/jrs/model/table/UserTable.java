package com.jusco.taste.jrs.model.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jusco.taste.jrs.model.User;
import com.jusco.taste.jrs.utils.DBUtil;


public class UserTable {

    public static User getUserByID(String id){
        String sql = "SELECT * FROM `users` WHERE `id` =  " + id;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next())
                return new User(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException e) {
                e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                //conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
