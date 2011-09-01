package com.jusco.taste.jrs.model.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jusco.taste.jrs.model.Product;
import com.jusco.taste.jrs.utils.DBUtil;
import com.jusco.taste.jrs.utils.StringUtil;


public class ProductTable {
    public static List<Product> getProducts(Collection<String> ids){
        List<Product> products = new ArrayList<Product>();
        String idString = StringUtil.connectString(ids, ", ");

        String sql = "SELECT * FROM `products` WHERE `id` IN ( " + idString + " )";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt("id"), rs.getString("title"));
                if(product != null){
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                try {
                    rs.close();
                    pstmt.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return products;
    }

    public static Map<String, Product> getProductMap(Collection<String> ids){
        Map<String, Product> movies = new HashMap<String, Product>();
        String idString = StringUtil.connectString(ids, ", ");

        String sql = "SELECT * FROM `product` WHERE `id` IN ( " + idString + " )";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Product product = new Product(rs.getInt("id"), rs.getString("title"));
                if(product != null){
                    movies.put(String.valueOf(product.getId()), product);
                }
            }
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
        return movies;
    }

    public static List<Product> getAllMovies(){
        List<Product> products = new ArrayList<Product>();

        String sql = "SELECT * FROM `products`";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt("id"), rs.getString("title"));
                if(product != null){
                    products.add(product);
                }
            }
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
        return products;
    }

}
