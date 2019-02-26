package filter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.ofs.training.java.pojo.PojoServicePerson;

import exception.ErrCode;
import helper.files.QueryStatement;

public class AuthenticationService {

    public PojoServicePerson login(Connection connection, PojoServicePerson person) throws SQLException {

        PreparedStatement prpstmt = connection.prepareStatement(QueryStatement.validateCredentials.toString());
        prpstmt.setString(1, person.getPassword());
        prpstmt.setString(2, person.getIs_admin());
        ResultSet resultset = prpstmt.executeQuery();

        if(!(resultset.next())) {
            System.out.println(ErrCode.INVALID_CREDENTIALS);
        }
        return person;
    }
}
