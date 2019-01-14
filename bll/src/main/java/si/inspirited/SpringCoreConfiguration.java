package si.inspirited;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import si.inspirited.domain.dao.UserManagementDAO;
//import si.inspirited.domain.dao.UserManagementDAOImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import si.inspirited.ejb.UserManagerBean;

import java.util.logging.Level;
import java.util.logging.Logger;


@Configuration
public class SpringCoreConfiguration {
  //  @Bean
    public main.java.si.inspirited.domain.dao.UserManagementDAO userManagementDAO() {
        return null; //new main.java.si.inspirited.domain.dao.UserManagementDAOImpl();
    }

    @Bean
    public UserManagerBean userManagerBean() {
        return new UserManagerBean();
    }




}
