package com.ofs.training.java.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ofs.training.java.pojo.PojoServicePerson;
import com.ofs.training.java.service.ServicePerson;
import com.ofs.training.java.utility.AppException;
import com.ofs.training.java.utility.ConnectionManager;

@Controller
public class PersonController {

    @Autowired
    ServicePerson person;

    @RequestMapping(value="/person", method=RequestMethod.GET)
    public String readAll(ModelMap model) throws Exception {

        ConnectionManager.init();
        Connection connection = ConnectionManager.getConnection();
        List<PojoServicePerson> personView = person.readAll(connection);
        model.addAttribute("personView", personView);
        return "value";
    }

    @RequestMapping(value="/person/{id}", method=RequestMethod.GET)
    public PojoServicePerson read(@PathVariable("id") long id) throws ClassNotFoundException, SQLException {
        boolean addressFlag = false;
        PojoServicePerson pojoperson = null;
        ConnectionManager.init();
        Connection connection = ConnectionManager.getConnection();
        PojoServicePerson person = ServicePerson.read(connection, pojoperson, addressFlag);
        ConnectionManager.release(connection, true);
        return person;
    }

    @RequestMapping(value="/person", method=RequestMethod.PUT)
    public PojoServicePerson create(@RequestBody PojoServicePerson person) throws SQLException, AppException, ParseException, ClassNotFoundException {

        ConnectionManager.init();
        Connection connection = ConnectionManager.getConnection();
        PojoServicePerson createdPerson = ServicePerson.create(connection ,person);
        ConnectionManager.release(connection, true);
        return createdPerson;
    }
}