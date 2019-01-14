package si.inspirited.config;

import org.springframework.context.annotation.Configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

//@Configuration
//@ApplicationScoped
//@FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class JSF23Activate {

    FacesContext facesContext = FacesContext.getCurrentInstance();
    //@Inject
    //private FacesContext facesContext;


}
