package com.jusco.taste.jrs.model.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jusco.taste.jrs.model.User;
import com.jusco.taste.jrs.utils.DBUtil;

public class UserTable {
	public final static String TABLE_NAME = "users";
	public final static String ID_COLUMN = "id";
	public final static String NAME_COLUMN = "name";
		
	public static void insertUser(User user){
			
	}

	public static User getUserByID(String userID){
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID_COLUMN + " =  " + userID + " ";
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next())
				return new User(rs.getInt(ID_COLUMN), rs.getString(NAME_COLUMN));
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
