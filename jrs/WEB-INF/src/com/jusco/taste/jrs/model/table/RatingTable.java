package com.jusco.taste.jrs.model.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jusco.taste.jrs.model.Product;
import com.jusco.taste.jrs.model.ProductList;
import com.jusco.taste.jrs.utils.DBUtil;

public class RatingTable {

    public static ProductList getProductsByUserID(String userID) {
        String sql = "SELECT * FROM `ratings` as `r`, `products` as `p` WHERE `p`.`id` = `m`.`id` AND `r`.`user_id` = " + userID;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ProductList products = new ProductList();
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt("products.id"), rs.getString("products.title"));
                products.add(product, rs.getFloat("ratings.rating"));
            }
            rs.close();
            pstmt.close();
            //conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
