package com.jusco.taste.jrs.model.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jusco.taste.jrs.model.User;
import com.jusco.taste.jrs.utils.DBUtil;


public class UserTable {

    public static User getUserByID(String id){
        String sql = "SELECT * FROM `users` WHERE `id` = " + id;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User uesr = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next())
                uesr = new User(rs.getInt("id"), rs.getString("name"));
            rs.close();
            pstmt.close();
            //conn.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return uesr;
    }
}
