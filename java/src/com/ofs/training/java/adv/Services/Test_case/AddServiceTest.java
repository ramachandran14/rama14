package com.ofs.training.java.adv.Services.Test_case;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ofs.training.java.adv.Services.AddressPojo;
import com.ofs.training.java.adv.Services.CrudOperations;

@Test
public class AddServiceTest {

    Connection con;
    CrudOperations crud;

    @BeforeClass
    void init() throws Exception{

        crud = new CrudOperations();
    }

    private static final String ASSERT_FAIL_MSG = " expected:<%s> but was:<%s>";
    @Test
    private void testCreate_positive() throws ClassNotFoundException, SQLException {

        con = CrudOperations.getConnection();
        AddressPojo addr = new AddressPojo();
        addr.setStreet("rajaji");
        addr.setCity("kovai");
        addr.setPostal_code(615115);

        addr = crud.create(con, addr);

        Long Id = addr.getId();
        try {

            Assert.assertEquals(Long.valueOf(Id), Long.valueOf("148"), "success");
        } catch(Exception e) {

            Assert.fail(e.getMessage());
        }
    }

    @Test
    private void testCreate_negative() {
        try {
            con = CrudOperations.getConnection();
            AddressPojo addr = new AddressPojo();
            addr.setStreet("rajaji");
            addr.setCity("kovai");
            addr.setPostal_code(615115);

            addr = crud.create(con, addr);

            Long Id = addr.getId();
            String Expected = "NULL VALUE";
            Assert.fail(String.format(Expected, Id));
        } catch(Exception e) {
            String actualErrCode = e.getMessage();
            Assert.assertEquals(actualErrCode, "NULL VALUE");
        }
    }
}






