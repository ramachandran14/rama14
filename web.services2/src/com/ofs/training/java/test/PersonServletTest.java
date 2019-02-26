package com.ofs.training.java.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ofs.training.java.pojo.PojoServiceAddress;
import com.ofs.training.java.pojo.PojoServicePerson;

import exception.AppException;
import exception.ErrCode;
import helper.files.HttpMethod;
import helper.files.JsonConverter;
import helper.files.RequestHelper;

public class PersonServletTest {

    RequestHelper helper;

    @BeforeClass
    private void init() throws SQLException, IOException {
        helper = new RequestHelper();
        helper.setBaseUrl("http://localhost:8080/ws/");
    }

    @Test(dataProvider ="dpCreate", priority = 1)
    public void testCreate(PojoServicePerson input, PojoServicePerson expected, List<ErrCode> expectedError) {

        try {
            PojoServicePerson actual = helper.setSecured(false)
                                             .setMethod(HttpMethod.PUT)
                                             .setInput(input)
                                             .requestObject("person/create", PojoServicePerson.class);
            Assert.assertEquals(JsonConverter.toJson(actual), JsonConverter.toJson(expected));
        } catch (Exception e) {
            if (e instanceof AppException) {
                Assert.assertEquals(((AppException) e).getErrorCodes(), JsonConverter.toJson(expectedError));
            }
        }
    }

    @DataProvider
    Object[][] dpCreate() throws Exception {

        PojoServiceAddress PojoServiceAddress = new PojoServiceAddress("deras", "chennai", 600095);
        PojoServicePerson input = new PojoServicePerson("harish", "kumar", "harish@gmail.in", "14-08-1995", PojoServiceAddress);
        PojoServiceAddress PojoServiceAddress1 = new PojoServiceAddress(21,"deras", "chennai", 600095);
        PojoServicePerson expected = new PojoServicePerson(4,"harish", "kumar", "harish@gmail.in", "14-08-1995", PojoServiceAddress1);
        expected.setAddress_id(7);

        PojoServiceAddress PojoServiceAddress4 = new PojoServiceAddress("  ", "", 0);
        PojoServicePerson input4 = new PojoServicePerson("viki", "jai", "vicky@gmail.in", "1997-07-04", PojoServiceAddress4);
        List<ErrCode> expectedError = new ArrayList<>();
        expectedError.add(ErrCode.STREET_NULL);
        expectedError.add(ErrCode.CITY_NULL);
        expectedError.add(ErrCode.POSTALCODE_NULL);
        expectedError.add(ErrCode.NAME_DUPLICATED);
        expectedError.add(ErrCode.EMAIL_DUPLICATED);
        expectedError.add(ErrCode.DATE_FORMAT_INVALID);

        return new Object[][] {
            { input, expected, null },
            { input4, null, expectedError } };
    }

    @Test(dataProvider = "dpUpdate", priority = 2)
    public void testUpdate(PojoServicePerson input, PojoServicePerson expected, List<ErrCode> expectedError) {

        try {
            PojoServicePerson actual = helper.setSecured(false)
                                             .setMethod(HttpMethod.POST)
                                             .setInput(input)
                                             .requestObject("person/update", PojoServicePerson.class);
            Assert.assertEquals(JsonConverter.toJson(actual), JsonConverter.toJson(expected));
        } catch (Exception e) {
            if (e instanceof AppException) {
                Assert.assertEquals(((AppException) e).getErrorCodes(), JsonConverter.toJson(expectedError));
            }
        }
    }

    @DataProvider
    Object[][] dpUpdate() throws Exception {

        PojoServiceAddress PojoServiceAddress = new PojoServiceAddress(2,"up1", "upc1", 12345);
        PojoServicePerson input = new PojoServicePerson(2,"upfname", "uplname", "upe@gmail.in", "05-12-1990", PojoServiceAddress);
        PojoServicePerson expected = new PojoServicePerson(2,"upfname", "uplname", "upe@gmail.in", "05-12-1990", PojoServiceAddress);

        PojoServiceAddress PojoServiceAddress2 = new PojoServiceAddress(2,"marg", "ooty", 12345);
        PojoServicePerson input2 = new PojoServicePerson(2, null, null, "upe@gmail.in", "1997-12-05", PojoServiceAddress2);
        List<ErrCode> expectedError = new ArrayList<>();

        expectedError.add(ErrCode.FIRST_NAME_NULL);
        expectedError.add(ErrCode.LAST_NAME_NULL);
        expectedError.add(ErrCode.EMAIL_DUPLICATED);
        expectedError.add(ErrCode.DATE_FORMAT_INVALID);

        return new Object[][] {
            { input, expected, null },
            { input2, null, expectedError } };
    }

    @Test(dataProvider = "dpDelete", priority = 3)
    public void testDelete(PojoServicePerson input, int isDeleted, List<ErrCode> expectedError) {

        try {
            int actual = helper.setSecured(false)
                               .setMethod(HttpMethod.POST)
                               .setInput(input)
                               .requestObject("/person/delete", int.class);
            Assert.assertEquals(actual, isDeleted);
        } catch (Exception e) {
            if (e instanceof AppException) {
                Assert.assertNotEquals(((AppException) e).getErrorCodes(), JsonConverter.toJson(expectedError));
            }
        }
    }

    @DataProvider
    Object[][] dpDelete() throws Exception {

        PojoServicePerson input = new PojoServicePerson();
        PojoServiceAddress PojoServiceAddress = new PojoServiceAddress();
        long id = 1;
        input.setId(id);
        PojoServiceAddress.setId(id);
        input.setAddress(PojoServiceAddress);
        int isDeleted = 1;

        PojoServicePerson input2 = new PojoServicePerson();
        PojoServiceAddress PojoServiceAddress2 = new PojoServiceAddress();
        long id2 = 2;
        input2.setId(id2);
        PojoServiceAddress2.setId(id2);
        input2.setAddress(PojoServiceAddress2);
        List<ErrCode> expectedError = new ArrayList<>();
        expectedError.add(ErrCode.PERSON_NOT_FOUND);

        return new Object[][] {
            { input, isDeleted, null },
            { input2, false, expectedError } };
    }

    @Test(dataProvider = "dpRead", priority = 4)
    public void testRead(long id, PojoServicePerson expected, List<ErrCode> expectedError) {

        try {
            PojoServicePerson actual = helper.setSecured(false)
                                             .setMethod(HttpMethod.GET)
                                             .requestObject("/person/read?id=" + id, PojoServicePerson.class);
            Assert.assertEquals(JsonConverter.toJson(actual), JsonConverter.toJson(expected));
        } catch (Exception e) {
            if (e instanceof AppException) {
                Assert.assertNotEquals(((AppException) e).getErrorCodes(), JsonConverter.toJson(expectedError));
            }
        }
    }

    @DataProvider
    Object[][] dpRead() throws Exception {

        long id = 3;
        PojoServiceAddress PojoServiceAddress = new PojoServiceAddress(id, "updatedstreet1", "updatedCity1", 123456);
        PojoServicePerson expected = new PojoServicePerson(id, "jon", "snow", "cristiano@cr.com", "1945-05-05", PojoServiceAddress);

        long id2 = 1;
        List<ErrCode> expectedError = new ArrayList<>();
        expectedError.add(ErrCode.PERSON_NOT_FOUND);
        return new Object[][] {
            {id, expected, null},
            {id2, null, expectedError} };
    }

    @Test(dataProvider = "dpReadAll", priority = 5)
    public void testReadAll(int expected) {

        try {
            List<PojoServicePerson> actual = helper.setSecured(false)
                                                   .setMethod(HttpMethod.GET)
                                                   .requestObject("/person/readAll", PojoServicePerson.class, true);
            Assert.assertEquals(JsonConverter.toJson(actual.size()), JsonConverter.toJson(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider
    Object[][] dpReadAll() throws Exception {

        int expected = 3;

        return new Object[][] { {expected} };
    }
}
