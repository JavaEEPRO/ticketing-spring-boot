package si.inspirited.controllers.admin;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import si.inspirited.util.logger.InjectLogger;

import java.util.Map;

@Controller
public class AdminController {

    @InjectLogger
    private static Logger LOGGER;

    // inject via application.properties
    @Value("${welcome.message:testOverridesAll}")
    private String message = "Hello World";

    @RequestMapping("/settings")
    public String settings(Map<String, Object> model) {

        LOGGER.info("Tickets-WEB module says :: AdminController.class has returned :: 'settings.html'(on view)");

        model.put("message", this.message);
        return "settings";
    }
}
