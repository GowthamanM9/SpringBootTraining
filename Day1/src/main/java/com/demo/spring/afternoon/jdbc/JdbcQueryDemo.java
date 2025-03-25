package com.demo.spring.afternoon.jdbc;

import java.sql.*;

public class JdbcQueryDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryDb", "root", "P@ssword");

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from book");

        PreparedStatement pStmt = con.prepareStatement("select * from book");
        ResultSet pRs = pStmt.executeQuery();

        while (rs.next()) {
            System.out.println((rs.getString("isbn") + " "
                    + rs.getString("name") + " "
                    + rs.getString("author") + " "
                    + rs.getString(("genre"))));
        }

        while (pRs.next()) {
            System.out.println((pRs.getString("isbn") + " "
                    + pRs.getString("name") + " "
                    + pRs.getString("author") + " "
                    + pRs.getString(("genre"))));
        }
    }
}
