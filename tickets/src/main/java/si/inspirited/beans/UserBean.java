package si.inspirited.beans;

import si.inspirited.ejb.UserManagerBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UserManagerBean userManagerBean;

    public void saveUser() {
    //    System.out.println(userManagerBean.createUser());
    }
}
