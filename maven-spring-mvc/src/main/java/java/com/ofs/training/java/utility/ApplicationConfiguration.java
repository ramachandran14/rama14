package java.com.ofs.training.java.utility;

import java.com.ofs.training.java.service.ServiceAddress;
import java.com.ofs.training.java.service.ServicePerson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public static ServiceAddress getAddressServiceBean() {
        return new ServiceAddress();
    }

    @Bean
    public static ServicePerson getPersonServiceBean() {
        return new ServicePerson();
    }
}
