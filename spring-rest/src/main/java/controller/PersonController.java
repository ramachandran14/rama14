package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaxxer.hikari.HikariDataSource;

import model.PojoServicePerson;
import service.ServicePerson;
import utility.ConnectionManager;

@RestController
public class PersonController {

    @Autowired
    ServicePerson person;

    @GetMapping("/person")
    public List<PojoServicePerson> readAll() throws SQLException {

        HikariDataSource ds = ConnectionManager.hikariConnection();
        Connection connection = ds.getConnection();
        List<PojoServicePerson> pojoperson = person.readAll(connection);
        return  pojoperson;
    }
}