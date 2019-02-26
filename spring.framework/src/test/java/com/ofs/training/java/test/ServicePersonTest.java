package com.ofs.training.java.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ofs.training.java.pojo.PojoServiceAddress;
import com.ofs.training.java.pojo.PojoServicePerson;
import com.ofs.training.java.service.ServiceAddress;
import com.ofs.training.java.service.ServicePerson;
import com.ofs.training.java.utility.ConnectionManager;
import com.zaxxer.hikari.HikariDataSource;

@Test
public class ServicePersonTest {
    ServicePerson person;
    ServiceAddress address;
    HikariDataSource ds;
    {
        ds = ConnectionManager.hikariConnection();
    }
    @BeforeClass
    void init() throws Exception {
        person = new ServicePerson();
        address = new ServiceAddress();

    }

    private static final String INPUTS_MSG = "INPUTS: Person = %s, Address = %s.";
    private static final String ASSERT_FAIL_MSG = " expected:<%s> but was:<%s>";


    @Test(dataProvider = "testCreate_positive", priority = 1)
  private void testCreate_positive(PojoServicePerson actual, PojoServicePerson expected) throws SQLException {

      try {
          Connection connection = ds.getConnection();
          PojoServicePerson actualPerson = person.create(connection, actual);
          Assert.assertEquals(actualPerson.getId(), expected.getId());
          connection.close();
      } catch (Exception e) {
          Assert.fail();
      }
  }

  @DataProvider
  Object[][] testCreate_positive() throws SQLException, ClassNotFoundException, IOException {

      ArrayList<PojoServicePerson> list = new ArrayList<>();

      File file = new File(
              "D:\\dev\\training\\ramachandran.s\\services\\src\\com\\ofs\\training\\java\\resource\\actualData.csv");
      BufferedReader bufReader = new BufferedReader(new FileReader(file));
      String text;
      while ((text = bufReader.readLine()) != null) {

          PojoServiceAddress pojoaddress = new PojoServiceAddress();
          String[] str = text.split(",");
          pojoaddress.setStreet(str[0]);
          pojoaddress.setCity(str[1]);
          pojoaddress.setPostal_code(Integer.parseInt(str[2]));
          PojoServicePerson pojoperson = new PojoServicePerson();
          pojoperson.setFirst_name(str[3]);
          pojoperson.setLast_name(str[4]);
          pojoperson.setEmail(str[5]);
          String date = str[str.length - 1];
          pojoperson.setBirth_date(date);
          Date created_date = Date.valueOf(LocalDate.now(ZoneId.systemDefault()));
          pojoperson.setCreated_date(created_date);
          pojoperson.setAddress(pojoaddress);
          list.add(pojoperson);
      }

      ArrayList<PojoServicePerson> list2 = new ArrayList<>();
      File file2 = new File("D:\\dev\\training\\ramachandran.s\\services\\src\\com\\ofs\\training\\java\\resource\\expectedData.csv");
      BufferedReader bufreader2 = new BufferedReader(new FileReader(file2));
      String text2;
      while ((text2 = bufreader2.readLine()) != null) {
          String[] str2 = text2.split(",");
          PojoServicePerson person = new PojoServicePerson();
          person.setId(Long.parseLong(str2[0]));
          list2.add(person);
      }


      Object[][] value = new Object[list.size()][2];
      for (int index = 0; index < list.size(); index++) {
          value[index][0] = list.get(index);
          value[index][1] = list2.get(index);
      }
      return value;
  }

//    @Test(dataProvider = "testCreate_negative", priority = 2)
//    private void testCreate_negative(PojoServicePerson pojoperson, PojoServiceAddress pojoaddress, String expected)
//            throws SQLException, ParseException, ClassNotFoundException {
//
//        try {
//            Connection connection = ds.getConnection();
//            connection.setAutoCommit(false);
//            PojoServicePerson getPerson = person.create(connection, pojoperson);
//            Assert.fail(String.format(ASSERT_FAIL_MSG, "Duplicate Entry or Null value", getPerson.getFirst_name()));
//            connection.commit();
//        } catch (AppException e) {
//            Connection connection = ds.getConnection();
//            String actualErrorCode = e.getMessage();
//            Assert.assertEquals(actualErrorCode, expected);
//            connection.close();
//
//        }
//    }
//
//    @DataProvider
//    Object[][] testCreate_negative() throws SQLException, ClassNotFoundException {
//
//        PojoServiceAddress pojoaddress = new PojoServiceAddress();
//        pojoaddress.setStreet("tambaram");
//        pojoaddress.setCity("chennai");
//        pojoaddress.setPostal_code(543473);
//        PojoServicePerson pojoperson = new PojoServicePerson();
//        pojoperson.setFirst_name(null);
//        pojoperson.setLast_name("kumar");
//        pojoperson.setEmail("vino@gamil.com");
//        String date = "12-07-1990";
//        pojoperson.setBirth_date(date);
//        pojoperson.setAddress(pojoaddress);
//        String errmsg = "FIRST NAME CANNOT BE NULL OR EMPTY";
//
//        PojoServiceAddress pojoaddress1 = new PojoServiceAddress();
//        pojoaddress1.setStreet("tambaram");
//        pojoaddress1.setCity("chennai");
//        pojoaddress1.setPostal_code(543473);
//        PojoServicePerson pojoperson1 = new PojoServicePerson();
//        pojoperson1.setFirst_name("vino");
//        pojoperson1.setLast_name(null);
//        pojoperson1.setEmail("vino@gamil.com");
//        String date1 = "12-07-1990";
//        pojoperson1.setBirth_date(date1);
//        pojoperson1.setAddress(pojoaddress1);
//        String errmsg1 = "LAST NAME CANNOT BE NULL OR EMPTY";
//
//        PojoServiceAddress pojoaddress2 = new PojoServiceAddress();
//        pojoaddress2.setStreet("tambaram");
//        pojoaddress2.setCity("chennai");
//        pojoaddress2.setPostal_code(543473);
//        PojoServicePerson pojoperson2 = new PojoServicePerson();
//        pojoperson2.setFirst_name("manoj");
//        pojoperson2.setLast_name("ravi");
//        pojoperson2.setEmail(null);
//        String date2 = "12-07-1990";
//        pojoperson2.setBirth_date(date2);
//        pojoperson2.setAddress(pojoaddress2);
//        String errmsg2 = "EMAIL CANNOT BE NULL OR EMPTY";
//
//        PojoServiceAddress pojoaddress3 = new PojoServiceAddress();
//        pojoaddress3.setStreet("tambaram");
//        pojoaddress3.setCity("chennai");
//        pojoaddress3.setPostal_code(543473);
//        PojoServicePerson pojoperson3 = new PojoServicePerson();
//        pojoperson3.setFirst_name("abi");
//        pojoperson3.setLast_name("kunal");
//        pojoperson3.setEmail("abi@gamil.com");
//        String date3 = null;
//        pojoperson3.setBirth_date(date3);
//        pojoperson3.setAddress(pojoaddress3);
//        String errmsg3 = "BIRTH DATE CANNOT BE NULL OR EMPTY";
//
//        PojoServiceAddress pojoaddress4 = new PojoServiceAddress();
//        pojoaddress4.setStreet("tambaram");
//        pojoaddress4.setCity("chennai");
//        pojoaddress4.setPostal_code(0);
//        PojoServicePerson pojoperson4 = new PojoServicePerson();
//        pojoperson4.setFirst_name("raj");
//        pojoperson4.setLast_name("kartt");
//        pojoperson4.setEmail("raj@gamil.com");
//        String date4 = "01-01-1890";
//        pojoperson4.setBirth_date(date4);
//        pojoperson4.setAddress(pojoaddress4);
//        String errmsg4 = "POSTAL CODE CANNOT BE NULL OR EMPTY";
//
//        PojoServiceAddress pojoaddress5 = new PojoServiceAddress();
//        pojoaddress5.setStreet(null);
//        pojoaddress5.setCity("chennai");
//        pojoaddress5.setPostal_code(543473);
//        PojoServicePerson pojoperson5 = new PojoServicePerson();
//        pojoperson5.setFirst_name("ram");
//        pojoperson5.setLast_name("kumar");
//        pojoperson5.setEmail("ram@gamil.com");
//        String date5 = "12-07-1997";
//        pojoperson5.setBirth_date(date5);
//        pojoperson5.setAddress(pojoaddress5);
//        String errmsg5 = "STREET CANNOT BE NULL OR EMPTY";
//
//        return new Object[][] { { pojoperson, pojoaddress, errmsg }, { pojoperson1, pojoaddress1, errmsg1 },
//            { pojoperson2, pojoaddress2, errmsg2 }, { pojoperson3, pojoaddress3, errmsg3 },
//            { pojoperson4, pojoaddress4, errmsg4 }, { pojoperson5, pojoaddress5, errmsg5 } };
//    }

    @Test(dataProvider = "testRead_positive", priority = 3)
    private void testRead_positive(Connection connection, PojoServicePerson pojoperson, Boolean addressFlag)
            throws SQLException {

        try {
            connection.setAutoCommit(false);
            PojoServicePerson readPerson = person.read(connection, pojoperson, addressFlag);
            Assert.assertEquals(readPerson, pojoperson,
                    String.format(INPUTS_MSG, pojoperson.getFirst_name(), pojoperson.getAddress().getCity()));

            connection.commit();
            connection.close();

        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, pojoperson.getId(), e.getMessage()));
            connection.rollback();
        }
    }

    @DataProvider
    Object[][] testRead_positive() throws SQLException, ClassNotFoundException {
        Connection connection = ds.getConnection();

        PojoServicePerson pojoperson = new PojoServicePerson();
        pojoperson.setId(1);

        boolean addressFlag = true;

        return new Object[][] { { connection, pojoperson, addressFlag } };
    }

//    @Test(dataProvider = "testRead_negative", priority = 4)
//    private void testRead_negative(Connection connection, PojoServicePerson pojoperson, Boolean addressFlag)
//            throws SQLException {
//
//        try {
//            connection.setAutoCommit(false);
//            PojoServicePerson readPerson = person.read(connection, pojoperson, addressFlag);
//            Assert.fail(String.format(ASSERT_FAIL_MSG, readPerson.getId(), "Not in record"));
//            connection.rollback();
//        } catch (Exception e) {
//            String actualErrorCode = e.getMessage();
//            Assert.assertEquals(actualErrorCode, "ID DOESN'T EXIST");
//            connection.close();
//
//        }
//    }
//
//    @DataProvider
//    Object[][] testRead_negative() throws SQLException, ClassNotFoundException {
//        Connection connection = ds.getConnection();
//
//        PojoServicePerson pojoperson = new PojoServicePerson();
//        pojoperson.setId(100);
//
//        boolean addressFlag = true;
//
//        return new Object[][] { { connection, pojoperson, addressFlag } };
//    }

//    @Test(dataProvider = "testUpdate_positive", priority = 5)
//    private void testUpdate_positive(Connection connection, PojoServicePerson pojoperson) throws SQLException {
//
//        try {
//            connection.setAutoCommit(false);
//            PojoServicePerson updatePerson = person.update(connection, pojoperson);
//            Assert.assertEquals(updatePerson, pojoperson);
//            connection.commit();
//            connection.close();
//
//        } catch (Exception e) {
//            Assert.fail();
//            connection.rollback();
//        }
//    }
//
//    @DataProvider
//    Object[][] testUpdate_positive() throws SQLException, AppException, ParseException, ClassNotFoundException {
//        Connection connection = ds.getConnection();
//
//        PojoServicePerson pojoperson = new PojoServicePerson();
//        PojoServiceAddress pojoaddress = new PojoServiceAddress();
//        pojoperson.setId(1);
//        pojoperson.setFirst_name("update");
//        pojoperson.setLast_name("name");
//        pojoperson.setEmail("update@gmail.com");
//        String date = "19-12-1998";
//        pojoperson.setBirth_date(date);
//        pojoperson.setAddress(pojoaddress);
//
//        pojoaddress.setId(1);
//        pojoaddress.setStreet("fd street");
//        pojoaddress.setCity("scv221 city");
//        pojoaddress.setPostal_code(99090);
//
//        return new Object[][] { { connection, pojoperson } };
//    }

//    @Test(dataProvider = "testUpdate_negative", priority = 6)
//    private void testUpdate_negative(Connection connection, PojoServicePerson pojoperson) throws SQLException {
//
//        try {
//            connection.setAutoCommit(false);
//            person.update(connection, pojoperson);
//            Assert.fail(String.format(ASSERT_FAIL_MSG, "Cannot Update No record found"));
//            connection.commit();
//        } catch (Exception e) {
//            String actualErrorCode = e.getMessage();
//            Assert.assertEquals(actualErrorCode, "ID DOESN'T EXIST");
//            connection.rollback();
//            connection.close();
//
//        }
//    }
//
//    @DataProvider
//    Object[][] testUpdate_negative() throws SQLException, AppException, ParseException, ClassNotFoundException {
//        Connection connection = ds.getConnection();
//
//        PojoServicePerson pojoperson = new PojoServicePerson();
//        PojoServiceAddress pojoaddress = new PojoServiceAddress();
//        pojoperson.setId(15);
//        pojoperson.setFirst_name("update");
//        pojoperson.setLast_name("name");
//        pojoperson.setEmail("update@gmail.com");
//        String date = "19-12-1998";
//        pojoperson.setBirth_date(date);
//        pojoperson.setAddress(pojoaddress);
//
//        pojoaddress.setId(5);
//        pojoaddress.setStreet("fd street");
//        pojoaddress.setCity("scv221 city");
//        pojoaddress.setPostal_code(99090);
//
//        return new Object[][] { { connection, pojoperson } };
//    }

//    @Test(dataProvider = "readAll", priority = 7)
//    private void testreadAll(Connection connection) throws SQLException {
//        try {
//            List<PojoServicePerson> readAllPerson = person.readAll(connection);
//            Assert.assertEquals(readAllPerson, readAllPerson,
//                    String.format(INPUTS_MSG, readAllPerson.size(), "Not available"));
//            connection.close();
//
//        } catch (Exception e) {
//            Assert.fail(String.format(ASSERT_FAIL_MSG, "Record Not Found", "Not in record"));
//        }
//    }
//
//    @DataProvider
//    Object[][] readAll() throws SQLException, ClassNotFoundException {
//        Connection connection = ds.getConnection();
//        return new Object[][] { { connection } };
//    }

//    @Test(dataProvider = "testDelete_positive", priority = 8)
//    private void testDelete_positive(Connection connection, PojoServicePerson pojoperson) throws SQLException {
//
//        try {
//
//            int deletePerson = person.delete(connection, pojoperson);
//            Assert.assertEquals(deletePerson, 1);
//            connection.close();
//
//        } catch (Exception e) {
//            Assert.fail();
//        }
//    }
//
//   @DataProvider
//    Object[][] testDelete_positive() throws SQLException, ClassNotFoundException {
//        Connection connection = ds.getConnection();
//
//        PojoServicePerson pojoperson = new PojoServicePerson();
//        pojoperson.setId(1);
//        PojoServiceAddress pojoaddress = new PojoServiceAddress();
//        pojoperson.setAddress(pojoaddress);
//        pojoaddress.setId(1);
//
//        return new Object[][] { { connection, pojoperson } };
//    }

//    @Test(dataProvider = "testDelete_negative", priority = 9)
//    private void testDelete_negative(Connection connection, PojoServicePerson pojoperson) throws SQLException {
//        try {
//
//            person.delete(connection, pojoperson);
//            Assert.fail();
//        } catch (Exception e) {
//            String actualErrorCode = e.getMessage();
//            Assert.assertEquals(actualErrorCode, "ID DOESN'T EXIST");
//            connection.close();
//
//        }
//    }
//
//    @DataProvider
//    Object[][] testDelete_negative() throws SQLException, AppException, ClassNotFoundException {
//        Connection connection = ds.getConnection();
//
//        PojoServicePerson pojoperson = new PojoServicePerson();
//        pojoperson.setId(100);
//        PojoServiceAddress pojoaddress = new PojoServiceAddress();
//        pojoperson.setAddress(pojoaddress);
//        pojoaddress.setId(100);
//
//        return new Object[][] { { connection, pojoperson } };
//    }

    private void log(String format, String string) {
        System.out.format(format, string + "\n");
    }
}
