package com.ofs.training.java.utility;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ofs.training.java.pojo.PojoServiceAddress;
import com.ofs.training.java.pojo.PojoServicePerson;
import com.ofs.training.java.service.ServiceAddress;
import com.ofs.training.java.service.ServicePerson;

public class BeanFactory {

    public static ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

    public static PojoServiceAddress getAddressBean() {
        return context.getBean("address", PojoServiceAddress.class);
    }

    public static PojoServicePerson getPersonBean() {
        return context.getBean("person", PojoServicePerson.class);
    }

    public static ServiceAddress getAddressServiceBean() {
        return context.getBean("addressService", ServiceAddress.class);
    }

    public static ServicePerson getPersonServiceBean() {
        return context.getBean("personService", ServicePerson.class);
    }
}
