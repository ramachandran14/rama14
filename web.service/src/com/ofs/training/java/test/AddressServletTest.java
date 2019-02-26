package com.ofs.training.java.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ofs.training.java.pojo.PojoServiceAddress;
import com.ofs.training.java.pojo.PojoServicePerson;

import helper.files.HttpMethod;
import helper.files.RequestHelper;
import webservice.ServiceAddress;

public class AddressServletTest {

    ServiceAddress addressService;
    private static final String ASSERT_FAIL_MSG = " expected:<%s> but was:<%s>";

    @BeforeClass
    private void init() throws SQLException {
        addressService = new ServiceAddress();
    }

    @Test(dataProvider = "testRead_positive", priority = 1)
    public void testRead_positive(PojoServiceAddress expected) {

        try {
            RequestHelper.setBaseUrl("http://localhost:8080/ws");
            RequestHelper helper = new RequestHelper();
            helper.setMethod(HttpMethod.GET);
            PojoServiceAddress actual = helper.setSecured(false)
                                              .requestObject("/address/read?id=" + expected.getId(), PojoServiceAddress.class);
            Assert.assertEquals(actual.toString(), expected.toString());
            Connection connection = null;
            connection.close();
        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, expected, e.getMessage()));
        }

    }

    @DataProvider(name = "testRead_positive")
    Object[][] testRead_positive() throws SQLException {
        long id = 1;
        PojoServiceAddress expected = new PojoServiceAddress();
        expected.setId(id);
        expected.setCity("sainagar");
        expected.setStreet("chennai");
        expected.setPostal_code(668779);
        return new Object[][] { { expected } };
    }


    @Test(dataProvider = "dpCreate", priority = 2)
    public void testCreate(PojoServiceAddress input) {

        try {
            RequestHelper.setBaseUrl("http://localhost:8080/ws");
            RequestHelper helper = new RequestHelper();
            helper.setSecured(false).setMethod(HttpMethod.PUT).setInput(input);
            PojoServiceAddress actual = helper.setSecured(false)
                                              .requestObject("/address/create", PojoServiceAddress.class);
            input.setId(actual.getId());
            Assert.assertEquals(actual.toString(), input.toString());
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @DataProvider(name = "dpCreate")
    Object[][] testCreate() throws Exception {

        PojoServiceAddress input = new PojoServiceAddress();
        input.setStreet("garastreet");
        input.setCity("jammu");
        input.setPostal_code(617707);
        return new Object[][] { { input } };
    }

    @Test(dataProvider = "testUpdate_positive",  priority = 3)

    public void testUpdate_positive(PojoServiceAddress address, int expected) {
        try {
            RequestHelper.setBaseUrl("http://localhost:8080/ws");
            RequestHelper helper = new RequestHelper();
            helper.setSecured(false).setMethod(HttpMethod.POST).setInput(address);
            int actual = helper.setSecured(false)
                               .requestObject("/address/update", int.class);
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, expected, e.getMessage()));
        }
    }

    @DataProvider(name = "testUpdate_positive")
    Object[][] testUpdate_positive() {
        PojoServiceAddress address = new PojoServiceAddress();
        address.setId(4);
        address.setCity("gubihs");
        address.setStreet("ushh8hwi");
        address.setPostal_code(123456);
        int expected = 1;
        return new Object[][] { { address, expected } };

    }

    @Test(dataProvider = "testDelete_positive", priority = 4)
    public void testDelete_positive(long id, int expected) {
        try {
            RequestHelper.setBaseUrl("http://localhost:8080/ws");
            RequestHelper helper = new RequestHelper();
            helper.setMethod(HttpMethod.POST);
            int actual = helper.setSecured(false)
                               .requestObject("address/delete", int.class);
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, expected, e.getMessage()));
        }
    }

    @DataProvider(name = "testDelete_positive")
    Object[][] testDelete_positive() {
        long id = 6;
        PojoServiceAddress address = new PojoServiceAddress();
        address.setId(id);
        int expected = 1;
        return new Object[][] { { id, expected } };
    }


    @Test(dataProvider = "testReadAll_positive", priority = 1)
    public void testReadAll_positive(int expected) {

        List<PojoServicePerson> actual = null ;
        try {
            RequestHelper.setBaseUrl("http://localhost:8080/ws");
            RequestHelper helper = new RequestHelper();
            helper.setMethod(HttpMethod.GET);
            actual = helper.setSecured(false)
                           .requestObject("address/readAll",
                                   ArrayList.class);
            Assert.assertEquals(actual.size(), expected);
        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, expected, e.getMessage()));
        }
    }

    @DataProvider(name = "testReadAll_positive")
    Object[][] testReadAll_positive() throws SQLException {

        int expected = 14;
        return new Object[][] { { expected } };
    }
}
