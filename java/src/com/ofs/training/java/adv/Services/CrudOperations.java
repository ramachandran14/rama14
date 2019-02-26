//  CRUD Operations
//  Define AddressService class for CRUD (create, read, readAll, update and delete) operations for Address using JDBC
//  use PreparedStatement appropriately

package com.ofs.training.java.adv.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CrudOperations {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        CrudOperations crud = new CrudOperations();
        AddressPojo address = new AddressPojo();
        address.setId(2);
        crud.read(con, address);

        con.close();
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://pc1620:3306/ramachandran_s?useSSL=true";
        String user = "ramachandran_s";
        String pass = "demo";

        Connection connection = DriverManager.getConnection(url, user, pass);
        log("%s", "Successfully connected");

        return connection;
    }

    public AddressPojo create(Connection con, AddressPojo address) throws SQLException {

        if (address.street == null || address.city == null || address.postal_code == 0) {
            throw new RuntimeException("NULL NAME");
        }

        StringBuilder createQuery = new StringBuilder(" INSERT INTO address(street,city,postal_code) ")
                .append(" values (?,?,?) ");

        PreparedStatement statement = con.prepareStatement(createQuery.toString(), Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, address.getStreet());
        statement.setString(2, address.getCity());
        statement.setInt(3, address.getPostal_code());

        statement.executeUpdate();

        ResultSet resultset = statement.getGeneratedKeys();

        while (resultset.next()) {
            address.setId(resultset.getLong(1));
        }
        return address;
    }

    public AddressPojo read(Connection con, AddressPojo address) throws SQLException {

        StringBuilder readQuery = new StringBuilder(" SELECT id, street, city, postal_code ")
                        .append(" FROM address ")
                        .append(" WHERE id = ? ");

        PreparedStatement statement = con.prepareStatement(readQuery.toString());
        statement.setLong(1, address.getId());

        ResultSet resultset = statement.executeQuery();

        while (resultset.next()) {
            address.setStreet(resultset.getString("street"));
            address.setCity(resultset.getString("city"));
            address.setPostal_code(resultset.getInt("postal_code"));
        }

        if (address.street == null) {
            throw new RuntimeException("Id doesn't exist");
        }
        return address;
    }

    public List<Object> readAll(Connection con, AddressPojo address) throws SQLException {

        StringBuilder readAllQuery = new StringBuilder(" SELECT id, street, city, postal_code ")
                        .append(" FROM address ");

        PreparedStatement statement = con.prepareStatement(readAllQuery.toString());
        ResultSet resultset = statement.executeQuery();

        List<Object> allAddress = new ArrayList<>();

        while (resultset.next()) {
            address.setId(resultset.getLong("id"));
            address.setStreet(resultset.getString("street"));
            address.setCity(resultset.getString("city"));
            address.setPostal_code(resultset.getInt("postal_code"));
            allAddress.add(address);
        }
        return allAddress;
    }

    public AddressPojo update(Connection con, AddressPojo address) throws SQLException {

        StringBuilder updateQuery = new StringBuilder(" UPDATE address set street = ? , city = ?, postal_code = ? ")
                        .append(" WHERE id = ? ");

        PreparedStatement statement = con.prepareStatement(updateQuery.toString(), Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, address.getStreet());
        statement.setString(2, address.getCity());
        statement.setInt(3, address.getPostal_code());
        statement.setLong(4, address.getId());

        statement.executeUpdate();

        ResultSet resultset = statement.getGeneratedKeys();

        while (resultset.next()) {
            address.setId(resultset.getLong(1));
        }
        return address;
    }

    public void delete(Connection con, Long id) throws SQLException {

        StringBuilder deleteQuery = new StringBuilder(" DELETE ")
                        .append(" FROM address ")
                        .append(" WHERE id = ? ");

        PreparedStatement statement = con.prepareStatement(deleteQuery.toString());
        statement.setLong(1, id);

        statement.executeUpdate();
    }

    private static void log(String format, String string) {

        System.out.format(format, string + "\n");
    }
}
