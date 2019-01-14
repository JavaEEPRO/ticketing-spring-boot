package si.inspirited.ejb;


import org.springframework.context.annotation.ComponentScan;
import si.inspirited.domain.dto.User.UserDTO;
import si.inspirited.domain.entity.User;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@ComponentScan
@Stateless
@LocalBean
public class UserManagerBean {

    @PersistenceContext(unitName = "TicketingPU")
    private EntityManager entityManager;

   /* public UserDTO createUser() {

        User user = new User();
        user.setId(1);
        user.setName("Test User 1");

        entityManager.persist(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        

        return userDTO;
    }*/
}
