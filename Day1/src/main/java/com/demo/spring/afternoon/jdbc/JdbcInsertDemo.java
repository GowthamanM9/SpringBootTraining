package com.demo.spring.day1.afternoon.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcInsertDemo {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver"); // Path of class which can be found in Maven Dependencies.
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryDb", "root", "P@ssword");

        PreparedStatement pSt= con.prepareStatement("insert into book(isbn, name, author, genre) values(?,?,?,?)");
        pSt.setString(1, "546655");
        pSt.setString(2, "No Time To Die");
        pSt.setString(3, "Ian Fleming");
        pSt.setString(4, "thriller");

        int updatedRows = pSt.executeUpdate();

        System.out.println("Rows inserted : " + updatedRows);
    }
}
