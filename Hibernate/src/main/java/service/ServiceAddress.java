package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.PojoServiceAddress;
import utility.AppException;
import utility.BeanFactory;
import utility.ErrCode;
import utility.QueryStatement;

public class ServiceAddress {

    public PojoServiceAddress create(Connection connection, PojoServiceAddress pojoaddress)
            throws SQLException, AppException {

        validation(connection, pojoaddress);

        PreparedStatement prpstmt = connection.prepareStatement(QueryStatement.createQuery.toString(),
                Statement.RETURN_GENERATED_KEYS);

        prpstmt.setString(1, pojoaddress.getStreet());
        prpstmt.setString(2, pojoaddress.getCity());
        prpstmt.setInt(3, pojoaddress.getPostal_code());

        prpstmt.executeUpdate();

        ResultSet resultSet = prpstmt.getGeneratedKeys();

        while (resultSet.next()) {
            pojoaddress.setId(resultSet.getLong(1));
        }
        return pojoaddress;
    }

    public PojoServiceAddress read(Connection connection, PojoServiceAddress pojoaddress)
            throws SQLException, AppException {

        PreparedStatement prpstmt = connection.prepareStatement(QueryStatement.readQuery.toString());
        prpstmt.setLong(1, pojoaddress.getId());

        ResultSet tablevalue = prpstmt.executeQuery();

        while (tablevalue.next()) {
            pojoaddress.setStreet(tablevalue.getString("street"));
            pojoaddress.setCity(tablevalue.getString("city"));
            pojoaddress.setPostal_code(tablevalue.getInt("postal_code"));

        }

        if (pojoaddress.getStreet() == null) {

            throw new AppException(ErrCode.ADDRESS_NOT_FOUND);
        } else {
            return pojoaddress;
        }
    }

    public List<Object> readAll(Connection connection, PojoServiceAddress pojoaddress) throws SQLException {

        PreparedStatement prpstmt = connection.prepareStatement(QueryStatement.readAllQuery.toString());
        ResultSet tablevalue = prpstmt.executeQuery();
        List<Object> allAddress = new ArrayList<>();

        while (tablevalue.next()) {
            pojoaddress.setId(tablevalue.getLong("id"));
            pojoaddress.setStreet(tablevalue.getString("street"));
            pojoaddress.setCity(tablevalue.getString("city"));
            pojoaddress.setPostal_code(tablevalue.getInt("postal_code"));
            allAddress.add(pojoaddress);

        }
        return allAddress;
    }

    public int update(Connection connection, PojoServiceAddress pojoaddress)
            throws SQLException, AppException {

        validation(connection, pojoaddress);

        PreparedStatement prpstmt = connection.prepareStatement(QueryStatement.updateQuery.toString(),
                Statement.RETURN_GENERATED_KEYS);
        prpstmt.setString(1, pojoaddress.getStreet());
        prpstmt.setString(2, pojoaddress.getCity());
        prpstmt.setInt(3, pojoaddress.getPostal_code());
        prpstmt.setLong(4, pojoaddress.getId());

        int rowsaffected = prpstmt.executeUpdate();

        if (rowsaffected == 0) {
            throw new AppException(ErrCode.ADDRESS_NOT_FOUND);
        }

        ResultSet resultSet = prpstmt.getGeneratedKeys();
        while (resultSet.next()) {
            pojoaddress.setId(resultSet.getLong(1));
        }
        return rowsaffected;

    }

    public int delete(Connection connection, PojoServiceAddress pojoaddress) throws SQLException, AppException {

        PreparedStatement prpstmt = connection.prepareStatement(QueryStatement.deleteQuery.toString());
        prpstmt.setLong(1, pojoaddress.getId());
        int rowsaffected = prpstmt.executeUpdate();

        if (rowsaffected == 0) {
            throw new AppException(ErrCode.ADDRESS_NOT_FOUND);
        }
        return rowsaffected;
    }

    public List<PojoServiceAddress> search(Connection connection, String[] fieldName, String searchText)
            throws SQLException {

        StringBuilder searchQuery = new StringBuilder().append(" SELECT id, street, city, postal_code ")
                .append("   FROM address_service               ").append("  WHERE                               ");
        for (int i = 0; i <= fieldName.length - 1; i++) {

            String db_column_name = null;
            switch (fieldName[i]) {

            case "street":
                db_column_name = "street";
                break;

            case "city":
                db_column_name = "city";
                break;

            case "postal_code":
                db_column_name = "postal_code";
                break;
            }
            if (i == 0) {
                searchQuery.append(db_column_name).append(" LIKE ? ");
            } else {
                searchQuery.append(" OR " + db_column_name).append(" LIKE ? ");

            }
        }
        List<PojoServiceAddress> addr = new ArrayList<>();

        PreparedStatement stmt = connection.prepareStatement(searchQuery.toString());

        for (int index = 1; index <= fieldName.length; index++) {
            stmt.setString(index, searchText + "%");
        }
        ResultSet result = stmt.executeQuery();
        while (result.next()) {
            PojoServiceAddress pojoaddress = BeanFactory.getAddressBean();
            pojoaddress.setId(result.getLong("id"));
            pojoaddress.setStreet(result.getString("street"));
            pojoaddress.setCity(result.getString("city"));
            pojoaddress.setPostal_code(result.getInt("postal_code"));
            addr.add(pojoaddress);
        }
        return addr;

    }

    public void validation(Connection connection, PojoServiceAddress pojoaddress) throws SQLException {

        if (pojoaddress.getStreet() == null || pojoaddress.getStreet().trim().length() <= 0) {
            throw new AppException(ErrCode.STREET_NULL);
        }

        if (pojoaddress.getCity() == null || pojoaddress.getCity().trim().length() <= 0) {
            throw new AppException(ErrCode.CITY_NULL);
        }

        if (pojoaddress.getPostal_code() == 0) {
            throw new AppException(ErrCode.POSTALCODE_NULL);
        }
    }

    public static ServiceAddress getAddressServiceBean() {
        return null;
    }
}
