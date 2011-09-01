package com.jusco.taste.jrs.servlet;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jusco.taste.jrs.utils.*;


public class RecommenderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String CONTENT_TYPE = "text/html;charset=GBK";

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException {

        response.setContentType(CONTENT_TYPE);


        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int n=1;

        for(int i=1;i<=5;i++){

            n*=i;

        }
        Connection conn;

        try {
            conn = DBUtil.getConnection();
            Statement st = conn.createStatement();

            String sql = "select * from users";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                out.println(rs.getInt(1));
                out.println(rs.getString(2));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }


        out.println("<html>");

        out.println("<head><title>TestServlet</title></head>");

        out.println("<body>");

        out.println("<P>5!="+n+"</P>");

        out.println("</body></html>");

        out.close();

    }
}
