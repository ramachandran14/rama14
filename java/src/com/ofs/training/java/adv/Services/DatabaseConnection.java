package com.ofs.training.java.adv.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    public static void main(String args[]) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://pc1620:3306/ramachandran_s?useSSL=false",
                "ramachandran_s", "demo");

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM college");

        while (rs.next()) {

            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        }
        con.close();
    }
}
