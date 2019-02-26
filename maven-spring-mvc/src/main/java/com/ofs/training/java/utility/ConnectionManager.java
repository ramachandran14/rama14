package com.ofs.training.java.utility;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionManager {

    private static HikariDataSource ds;

//     public static Connection getConnection() throws ClassNotFoundException,
//     SQLException {
//
//     String url = "jdbc:mysql://pc1620:3306/ramachandran_s?useSSL=true";
//     String user = "ramachandran_s";
//     String pass = "demo";
//
//     Connection connection = DriverManager.getConnection(url, user, pass);
//
//     return connection;
//     }

    // static {
    //
    // HikariConfig config = new HikariConfig();
    // config.setMaximumPoolSize(2);
    // ds = new HikariDataSource(config);
    // }
    //
    // public Connection getConnection() throws SQLException {
    // Connection connection = ds.getConnection();
    // connection.setAutoCommit(false);
    // return connection;
    // }
    public static HikariDataSource hikariConnection() {

        HikariConfig config = new HikariConfig("D://dev//training//ramachandran.s//services//src//com//ofs//training//java//resource//hikariConfig.properties");
        config.setMaximumPoolSize(2);
        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }
}