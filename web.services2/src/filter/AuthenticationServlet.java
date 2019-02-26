package filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;

import com.mysql.jdbc.Connection;
import com.ofs.training.java.pojo.PojoServicePerson;
import com.zaxxer.hikari.HikariDataSource;

import connection.ConnectionManager;
import exception.AppException;
import helper.files.JsonConverter;

public class AuthenticationServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        PojoServicePerson pojoPerson = new PojoServicePerson();

        HikariDataSource ds = ConnectionManager.hikariConnection();
        Connection connection = null;
        try {
            connection = (Connection) ds.getConnection();
            BufferedReader reader  = req.getReader();
            List<String> jsonlines = reader.lines().collect(Collectors.toList());
            String personJson = String.join("", jsonlines);
            System.out.format("Input JSON >> %s", personJson);

            out.println(JsonConverter.toJson(pojoPerson));
            res.setStatus(HttpStatus.SC_OK);
            out.println(JsonConverter.toJson(pojoPerson));
        connection.close();
        } catch (AppException e) {
            out.write(JsonConverter.toJson(e.getErrorCodes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
