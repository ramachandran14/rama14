package utility;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.PojoServiceAddress;
import model.PojoServicePerson;
import service.ServiceAddress;
import service.ServicePerson;

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
