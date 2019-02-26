package com.ofs.training.java.adv.Services.Test_case;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ofs.training.java.adv.Services.CrudOperations;
import com.ofs.training.java.adv.Services.PersonPojo;
import com.ofs.training.java.adv.Services.PersonService;

@Test
public class PersonServiceTest {
    Connection con;
    PersonService service;
    CrudOperations crud;

    @BeforeClass
    void init() throws Exception {

        service = new PersonService();
        crud = new CrudOperations();

    }

//     @Test
//     private void testcreate_positive() throws SQLException, ParseException,
//     ClassNotFoundException {
//
//     con = PersonService.getConnection();
//     AddressPojo address = new AddressPojo();
//     address.setStreet("abcstreet");
//     address.setCity("covai");
//     address.setPostal_code(88345);
//     address = crud.create(con, address);
//
//     PersonPojo person = new PersonPojo();
//     person.setName("samaaid");
//     person.setEmail("mana@gamil.com");
//     Date date = Date.valueOf("1980-10-12");
//     person.setBirth_date(date);
//     Date created_date = Date.valueOf(LocalDate.now(ZoneId.systemDefault()));
//     person.setCreated_date(created_date);
//     person.setAddress(address);
//     PersonPojo per = service.create(con, person, address);
//
//     Long personId = per.getId();
//     try {
//
//     Assert.assertEquals(Long.valueOf(personId), Long.valueOf("7"), "success");
//     } catch(Exception e) {
//
//     Assert.fail(e.getMessage());
//     }
//     }

//     @Test
//     private void testcreate_negative() {
//     try {
//     con = PersonService.getConnection();
//     AddressPojo address = new AddressPojo();
//     address.setStreet("markstreet");
//     address.setCity("ufdd");
//     address.setPostal_code(12345);
//     address = crud.create(con, address);
//
//     PersonPojo person = new PersonPojo();
//     person.setName(null);
//     person.setEmail("abchdhsd@gamil.com");
//     Date date = Date.valueOf("1980-10-12") ;
//     person.setBirth_date(date);
//     Date created_date = Date.valueOf(LocalDate.now(ZoneId.systemDefault()));
//     person.setCreated_date(created_date);
//     person.setAddress(address);
//     PersonPojo per = service.create(con, person, address);
//
//     Long personId = per.getId();
//     String expected = "name is null";
//
//     Assert.fail(String.format( expected, personId));
//     } catch (Exception e) {
//     String actualErrCode = e.getMessage();
//     Assert.assertEquals(actualErrCode, "name is null" );
//     }
//     }

     @Test
     private void testRead_positive() throws SQLException, ParseException,
     ClassNotFoundException {

     try {

     con = PersonService.getConnection();
     PersonPojo person = new PersonPojo();
     person.setId(32);
     boolean addressFlag = true;
     person = service.read(con, person, addressFlag);

     String city = person.getAddress().getCity();
     Assert.assertEquals(String.valueOf(city), String.valueOf("salem"),
     "success");
     } catch(Exception e) {
     Assert.fail(e.getMessage());
     }
     }

    @Test
    private void testRead_negative() throws SQLException, ParseException, ClassNotFoundException {

        try {

            con = PersonService.getConnection();
            PersonPojo person = new PersonPojo();
            person.setId(70);
            boolean addressFlag = true;
            person = service.read(con, person, addressFlag);

        } catch (Exception e) {
            String actualErrCode = e.getMessage();
            Assert.assertEquals(actualErrCode, "Id doesn't exist");
        }
    }

}

