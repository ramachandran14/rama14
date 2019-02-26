package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.PojoServicePerson;
import utility.AppException;

public class ServicePerson {

    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    public static void create(Connection connection, PojoServicePerson pojoperson)
            throws SQLException, AppException, ParseException {

        PojoServicePerson pojoperson1 = null;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            pojoperson1 = new PojoServicePerson();
            pojoperson1.setFirst_name("ram");
            pojoperson1.setLast_name("chandran");
            pojoperson1.setEmail("ram@gmail.com");

            sessionObj.save(pojoperson1);
            sessionObj.getTransaction().commit();
        } catch (Exception e) {
            if (null != sessionObj.getTransaction()) {
                sessionObj.getTransaction().rollback();
            }
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List read() {
        List PersonList = new ArrayList();

        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            PersonList = sessionObj.createQuery("FROM Person").list();
            sessionObj.getTransaction().commit();
        } catch (Exception e) {
            if (null != sessionObj.getTransaction()) {
                sessionObj.getTransaction().rollback();
            }
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return PersonList;
    }

    public static void update(int id) {
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            PojoServicePerson pojoperson1 = (PojoServicePerson) sessionObj.get(PojoServicePerson.class, id);

            pojoperson1.setFirst_name("");
            pojoperson1.setLast_name("");
            pojoperson1.setEmail("");

            sessionObj.getTransaction().commit();
        } catch (Exception e) {
            if (null != sessionObj.getTransaction()) {
                sessionObj.getTransaction().rollback();
            }
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }



    private static SessionFactory buildSessionFactory() {
        return null;
    }

    public static void logs(String format) {
        System.out.format(format);
    }

    public static void log(String format, Object vals) {
        System.out.format(format, vals + "\n");
    }
}
