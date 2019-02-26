// Txn Management with Cascade operations
// Define PersonService class for Person object CRUDs, with cascade
// PersonService.create(..) should create Address as well, if Address is provided
// PersonService.read(..., boolean includeAddress) will include Address objects in the returned Person objects if includeAddress flag is true
// if Person creation fails (duplicate email), respective Address record should not be created as well

package com.ofs.training.java.adv.Services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.ofs.training.java.adv.coll.Person;

public class PersonService {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection connection = getConnection();
        PersonService service = new PersonService();
        CrudOperations crud = new CrudOperations();
        PersonPojo person = new PersonPojo();
        AddressPojo address = new AddressPojo();

        // create details
        address.setStreet("suhilnagar");
        address.setCity("banglore");
        address.setPostal_code(876687);
        address = crud.create(connection, address);

        person.setName("samam");
        person.setEmail("yubuu@gamil.com");
        Date date = Date.valueOf("1975-02-12");
        person.setBirth_date(date);
        Date created_date = Date.valueOf(LocalDate.now(ZoneId.systemDefault()));
        person.setCreated_date(created_date);
        person.setAddress(address);

        person = service.create(connection, person, address);
        log("%s", person.getId() + "is created");

        // read details
        // person.setId(5);
        //
        // boolean addressFlag = true;
        // person = service.read(connection, person, addressFlag);
        // System.out.println(person.name + " " + person.email + " " +
        // person.getAddress().getCity() +" " +person.getAddress().getStreet());

        // read all details
        // Connection con = getConnection();
        //
        // List<Person> allPersonDetails = service.readAll(con);
        // for(Person details : allPersonDetails){
        // log("%s", details.name + " " +details.email + " " +
        // details.birth_date + " " +
        // details.getAddress().getCity() + " " +
        // details.getAddress().getStreet());
        // }

        // update details
        // person.setName("virat");
        // person.setEmail("virat@gmail.com");
        // Date date = Date.valueOf("2014-10-18");
        // person.setBirth_date(date);
        // person.setId(5);
        //
        // address.setStreet("guru");
        // address.setCity("covai");
        // address.setPostal_code(762673);
        // address.setId(5);
        //
        // //person = service.read(connection, person, true);
        // //address.setId(person.getAddress().getId());
        //
        // address = crud.update(connection, address);
        //
        // person.setAddress(address);
        // person = service.update(connection, person);
        // System.out.println(person.getName());

        // Delete details
        // person.setId(3);
        // address.setId(22);
        // person.setAddress(address);
        // service.delete(connection, person);
        // connection.close();
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://pc1620:3306/ramachandran_s?useSSL=true";
        String user = "ramachandran_s";
        String pass = "demo";

        Connection con = DriverManager.getConnection(url, user, pass);
        System.out.println("Successfully connected");

        return con;
    }

    public PersonPojo create(Connection con, PersonPojo person, AddressPojo address) throws SQLException {

        if (person.name == null) {
            throw new RuntimeException("name is null");
        }
        String createQuery = new StringBuilder()
                .append(" INSERT INTO person (name, email, birth_date, address_id, created_date) ")
                .append(" VALUES(?,?,?,?,?) ").toString();

        PreparedStatement statement = con.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);

        CrudOperations crud = new CrudOperations();

        crud.create(con, person.getAddress());
        person.getAddress().setId(address.getId());
        statement.setString(1, person.getName());
        statement.setString(2, person.getEmail());
        statement.setDate(3, (Date) person.getBirth_date());
        Date date = Date.valueOf("1980-10-12");
        person.getBirth_date();
        statement.setLong(4, person.getAddress().getId());
        statement.setDate(5, (Date) person.getCreated_date());
        Date created_date = Date.valueOf(LocalDate.now(ZoneId.systemDefault()));
        person.getCreated_date();

        statement.executeUpdate();

        ResultSet resultset = statement.getGeneratedKeys();
        resultset.next();
        person.setId(resultset.getLong(1));
        return person;
    }

    public PersonPojo read(Connection con, PersonPojo person, Boolean addressFlag) throws SQLException {

        StringBuilder readQuery = new StringBuilder()
                        .append(" SELECT name, email, address_id, birth_date, created_date ").append(" FROM person ")
                        .append(" WHERE id = ? ");

        CrudOperations crud = new CrudOperations();

        PreparedStatement statement = con.prepareStatement(readQuery.toString());
        statement.setLong(1, person.getId());
        ResultSet resultset = statement.executeQuery();

        if (resultset.next()) {

            person.setName(resultset.getString("name"));
            person.setEmail(resultset.getString("email"));
            person.setBirth_date(resultset.getDate("birth_date"));
            person.setCreated_date(resultset.getDate("created_date"));

            if (addressFlag == true) {
                AddressPojo address = new AddressPojo();
                address.setId(resultset.getLong("address_id"));
                person.setAddress(crud.read(con, address));
            }
        }
        if (person.name == null) {
            throw new RuntimeException("Id doesn't exist");
        }
        return person;
    }

    public List<Person> readAll(Connection con) throws SQLException {

        StringBuilder readAllQuery = new StringBuilder()
                        .append(" SELECT id, name, email, birth_date,created_date, address_id ").append(" FROM person ");

        PreparedStatement statement = con.prepareStatement(readAllQuery.toString());
        ResultSet resultset = statement.executeQuery();
        List<Person> allPersonDetails = new ArrayList<>();

        while (resultset.next()) {

            PersonPojo person = new PersonPojo();
            AddressPojo address = new AddressPojo();
            CrudOperations crud = new CrudOperations();

            person.setId(resultset.getLong("id"));
            person.setName(resultset.getString("name"));
            person.setEmail(resultset.getString("email"));
            person.setBirth_date(resultset.getDate("birth_date"));
            person.setCreated_date(resultset.getDate("created_date"));
            address.setId(resultset.getLong("address_id"));
            crud.read(con, address);
            person.setAddress(address);
            // allPersonDetails.add(person);
        }
        return allPersonDetails;
    }

    public PersonPojo update(Connection con, PersonPojo person) throws SQLException {

        StringBuilder updateQuery = new StringBuilder().append(" UPDATE person ")
                        .append(" SET name = ?, email = ?, birth_date = ? ").append(" WHERE id = ? ");

        PreparedStatement statement = con.prepareStatement(updateQuery.toString());

        statement.setString(1, person.getName());
        statement.setString(2, person.getEmail());
        statement.setDate(3, (Date) person.getBirth_date());
        statement.setLong(4, person.getId());
        int rowsaffected = statement.executeUpdate();

        if (rowsaffected == 0) {
            throw new RuntimeException("Record not found");
        }

        CrudOperations crud = new CrudOperations();
        crud.update(con, person.getAddress());

        return person;
    }

    public PersonPojo delete(Connection con, PersonPojo person) throws SQLException {

        StringBuilder deleteQuery = new StringBuilder().append(" DELETE ").append(" FROM  person ")
                        .append(" WHERE id = ? ");

        PreparedStatement statement = con.prepareStatement(deleteQuery.toString());

        CrudOperations crud = new CrudOperations();
        statement.setLong(1, person.getId());

        int rowsaffected = statement.executeUpdate();
        Long addressId = person.getAddress().getId();

        if (rowsaffected == 0) {
            throw new RuntimeException("Record not found");
        }

        crud.delete(con, addressId);
        return person;
    }

    public static void logs(String format) {
        System.out.format(format);
    }

    public static void log(String format, Object vals) {
        System.out.format(format, vals + "\n");
    }
}
