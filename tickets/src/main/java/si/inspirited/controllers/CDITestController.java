package si.inspirited.controllers;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import si.inspirited.util.logger.InjectLogger;
import si.inspirited.util.logger.ParentLogger;
//import org.springframework.View;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Map;

@Path("/home")
    @Controller
    public class CDITestController extends ParentLogger {

        //@InjectLogger
        //private Logger LOGGER;

        //@Inject
        //private UserManagerBean userManager;

        //@Inject
        //private Models models;

        @RequestMapping("/home")
        @GET
        @Produces("text/html")
        @View("hello.html")
        public String hello(Map<String, Object> model) {

            LOGGER.info("cdi test controller returned::hello"); //userManager.createUser().toString());//setText("Today is a sunny day");

            model.put("message", "text:success");
            return "hello";
        }
 }

