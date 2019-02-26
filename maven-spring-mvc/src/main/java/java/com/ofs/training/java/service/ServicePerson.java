package java.com.ofs.training.java.service;

import java.com.ofs.training.java.pojo.PojoServiceAddress;
import java.com.ofs.training.java.pojo.PojoServicePerson;
import java.com.ofs.training.java.utility.AppException;
import java.com.ofs.training.java.utility.ErrCode;
import java.com.ofs.training.java.utility.QueryStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePerson {

    @Autowired
    ServiceAddress address;

    public PojoServicePerson create(Connection connection, PojoServicePerson pojoperson)
            throws SQLException, AppException, ParseException {

        PreparedStatement prpstmt = connection.prepareStatement(QueryStatement.createQueryPerson.toString(),
                Statement.RETURN_GENERATED_KEYS);

        PojoServiceAddress pojoaddress = new PojoServiceAddress();
        pojoaddress = address.create(connection, pojoperson.getAddress());

        pojoperson.setAddress_id(pojoaddress.getId());

        prpstmt.setString(1, pojoperson.getFirst_name());
        prpstmt.setString(2, pojoperson.getLast_name());
        prpstmt.setString(3, pojoperson.getEmail());

        String date = pojoperson.getBirth_date();
        java.util.Date df = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        java.sql.Date sqlDate = new java.sql.Date(df.getTime());
        prpstmt.setDate(4, sqlDate);

        prpstmt.setLong(5, pojoperson.getAddress_id());
        Date created_date = Date.valueOf(LocalDate.now(ZoneId.systemDefault()));
        pojoperson.setCreated_date(created_date);
        prpstmt.setDate(6, pojoperson.getCreated_date());

        System.out.println(connection);
        ResultSet resultSet = prpstmt.getGeneratedKeys();


        while (resultSet.next()) {
            pojoperson.setId(resultSet.getLong(1));
            pojoperson.setId(pojoperson.getId());
        }
        prpstmt.executeUpdate();
        return pojoperson;

    }

    public PojoServicePerson read(Connection connection, PojoServicePerson pojoperson, Boolean addressFlag)
            throws SQLException, AppException {

        PreparedStatement prpstmt = connection.prepareStatement(QueryStatement.readQueryPerson.toString());
        prpstmt.setLong(1, pojoperson.getId());
        ResultSet resultSet = prpstmt.executeQuery();

        if (resultSet.next()) {

            pojoperson.setFirst_name(resultSet.getString("first_name"));
            pojoperson.setLast_name(resultSet.getString("last_name"));
            pojoperson.setEmail(resultSet.getString("email"));
            pojoperson.setBirth_date(resultSet.getString("birth_date"));
            pojoperson.setCreated_date(resultSet.getDate("created_date"));

            if (addressFlag == true) {

                PojoServiceAddress pojoaddress = new PojoServiceAddress();                pojoaddress.setId(resultSet.getLong("address_id"));
                pojoperson.setAddress(address.read(connection, pojoaddress));
            }
        }

        if (pojoperson.getFirst_name() == null) {

            throw new AppException(ErrCode.PERSON_NOT_FOUND);
        }

        return pojoperson;
    }

    public List<PojoServicePerson> readAll(Connection connection) throws SQLException {

        PreparedStatement prpstmt = connection.prepareStatement(QueryStatement.readAllQueryPerson.toString());
        ResultSet resultSet = prpstmt.executeQuery();
        List<PojoServicePerson> allPersonDetails = new ArrayList<>();

        while (resultSet.next()) {

            PojoServiceAddress pojoaddress = new PojoServiceAddress();
            PojoServicePerson pojoperson = new PojoServicePerson();

            pojoperson.setId(resultSet.getLong("id"));
            pojoperson.setFirst_name(resultSet.getString("first_name"));
            pojoperson.setLast_name(resultSet.getString("last_name"));
            pojoperson.setEmail(resultSet.getString("email"));
            pojoperson.setBirth_date(resultSet.getString("birth_date"));
            pojoperson.setCreated_date(resultSet.getDate("created_date"));
            pojoaddress.setId(resultSet.getLong("address_id"));
            address.read(connection, pojoaddress);
            pojoperson.setAddress(pojoaddress);
            allPersonDetails.add(pojoperson);

        }

        return allPersonDetails;
    }

    public int update(Connection connection, PojoServicePerson pojoperson)
            throws SQLException, AppException, ParseException {

        nullValidation(connection, pojoperson);

        PreparedStatement prpstmt = connection.prepareStatement(QueryStatement.updateQueryPerson.toString());
        prpstmt.setString(1, pojoperson.getFirst_name());
        prpstmt.setString(2, pojoperson.getLast_name());
        prpstmt.setString(3, pojoperson.getEmail());
        String date = pojoperson.getBirth_date();
        java.util.Date df = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        java.sql.Date sqlDate = new java.sql.Date(df.getTime());
        prpstmt.setDate(4, sqlDate);
        prpstmt.setLong(5, pojoperson.getId());

        int rowsaffected = prpstmt.executeUpdate();

        if (rowsaffected == 0) {
            throw new AppException(ErrCode.PERSON_NOT_FOUND);
        }

        address.update(connection, pojoperson.getAddress());

        return rowsaffected;
    }

    public int delete(Connection connection, PojoServicePerson pojoperson) throws SQLException, AppException {

        PreparedStatement prpstmt = connection.prepareStatement(QueryStatement.deleteQueryPerson.toString());
        prpstmt.setLong(1, pojoperson.getId());
        int rowsaffected = prpstmt.executeUpdate();

        if (rowsaffected == 0) {
            throw new AppException(ErrCode.PERSON_NOT_FOUND);
        }

        address.delete(connection, pojoperson.getAddress());

        return rowsaffected;
    }

    public void nullValidation(Connection connection, PojoServicePerson pojoperson)
            throws SQLException, ParseException {

        if (pojoperson.getFirst_name() == null || pojoperson.getFirst_name().trim().length() <= 0) {
            System.out.println();
            throw new AppException(ErrCode.FIRST_NAME_NULL);
        }

        if (pojoperson.getLast_name() == null || pojoperson.getLast_name().trim().length() <= 0) {
            throw new AppException(ErrCode.LAST_NAME_NULL);
        }

        if (pojoperson.getEmail() == null || pojoperson.getEmail().trim().length() <= 0) {
            throw new AppException(ErrCode.EMAIL_NULL);
        }

        if (pojoperson.getBirth_date() == null || pojoperson.getBirth_date().trim().length() <= 0) {
            throw new AppException(ErrCode.BIRTH_DATE_NULL);
        }

    }

    public void duplicateValidation(Connection connection, PojoServicePerson pojoperson)
            throws SQLException, ParseException {

        validateName(connection, pojoperson);
        validateEmail(connection, pojoperson);
        validateDate(pojoperson.getBirth_date());

    }

    public void validateName(Connection connection, PojoServicePerson pojoperson) throws SQLException, AppException {

        PreparedStatement prpstmt = connection.prepareStatement(QueryStatement.nameverify.toString());
        prpstmt.setString(1, pojoperson.getFirst_name());
        prpstmt.setString(2, pojoperson.getLast_name());
        ResultSet resultSet = prpstmt.executeQuery();

        if (resultSet.next()) {

            throw new AppException(ErrCode.NAME_DUPLICATED);
        }
    }

    public void validateEmail(Connection connection, PojoServicePerson pojoperson) throws SQLException, AppException {

        PreparedStatement prpstmt = connection.prepareStatement(QueryStatement.emailVerify.toString());
        prpstmt.setString(1, pojoperson.getEmail());
        ResultSet resultSet = prpstmt.executeQuery();

        if (resultSet.next()) {

            throw new AppException(ErrCode.EMAIL_DUPLICATED);
        }
    }

    public void validateDate(String date) throws ParseException {

        try {

            String dateToCheck = date;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate parsedDate = LocalDate.parse(dateToCheck, formatter);

            String checkedDate = parsedDate.format(formatter);
            dateToCheck.equals(checkedDate);
        } catch (Exception e) {

            throw new AppException(ErrCode.DATE_FORMAT_INVALID);
        }
    }

    public static void logs(String format) {
        System.out.format(format);
    }

    public static void log(String format, Object vals) {
        System.out.format(format, vals + "\n");
    }
}
