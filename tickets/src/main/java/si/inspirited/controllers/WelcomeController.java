package si.inspirited.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import si.inspirited.util.logger.InjectLogger;

import javax.inject.Inject;

@Controller
public class WelcomeController {

    @InjectLogger
    private static Logger LOGGER;

    @Inject
    private MessageSourceProperties messageSourceProperties;

    // inject via application.properties
    @Value("${welcome.message:testOverridesAll}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {

        LOGGER.info("welcome controller returned::welcome");

        LOGGER.info(messageSourceProperties.getBasename());

        model.put("message", this.message);
        return "welcome";
    }

}