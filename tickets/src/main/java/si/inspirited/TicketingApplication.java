package si.inspirited;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import si.inspirited.controllers.HomeController;
import si.inspirited.controllers.TicketingController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class TicketingApplication extends SpringBootServletInitializer{

	//private TemplateEngine templateEngine;
	//private Map<String, TicketingController> controllersByURL;


/*
	public TicketingApplication(final ServletContext servletContext) {

		super();

		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);

		// HTML is the default mode, but we will set it anyway for better understanding of code
		templateResolver.setTemplateMode(TemplateMode.HTML);
		// This will convert "home" to "/WEB-INF/templates/home.html"
		templateResolver.setPrefix("/templates/");
		templateResolver.setSuffix(".html");
		// Set template cache TTL to 1 hour. If not set, entries would live in cache until expelled by LRU
		templateResolver.setCacheTTLMs(Long.valueOf(3600000L));

		// Cache is set to true by default. Set to false if you want templates to
		// be automatically updated when modified.
		templateResolver.setCacheable(true);

		this.templateEngine = new TemplateEngine();
		this.templateEngine.setTemplateResolver(templateResolver);

		this.controllersByURL = new HashMap<String, TicketingController>();
		this.controllersByURL.put("/", new HomeController());
		//this.controllersByURL.put("/product/list", new ProductListController());
		//this.controllersByURL.put("/product/comments", new ProductCommentsController());
		//this.controllersByURL.put("/order/list", new OrderListController());
		//this.controllersByURL.put("/order/details", new OrderDetailsController());
		//this.controllersByURL.put("/subscribe", new SubscribeController());
		//this.controllersByURL.put("/userprofile", new UserProfileController());

	}


	public TicketingController resolveControllerForRequest(final HttpServletRequest request) {
		final String path = getRequestPath(request);
		return this.controllersByURL.get(path);
	}


	public ITemplateEngine getTemplateEngine() {
		return this.templateEngine;
	}



	private static String getRequestPath(final HttpServletRequest request) {

		String requestURI = request.getRequestURI();
		final String contextPath = request.getContextPath();

		final int fragmentIndex = requestURI.indexOf(';');
		if (fragmentIndex != -1) {
			requestURI = requestURI.substring(0, fragmentIndex);
		}

		if (requestURI.startsWith(contextPath)) {
			return requestURI.substring(contextPath.length());
		}
		return requestURI;
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(TicketingApplication.class, args);
	}

	@RestController
	class HelloController {

		@RequestMapping("/hello/{name}")
		String hello(@PathVariable String name) {

		    //System.out.println("0 config");
			return "Hi " + name + " !";

		}

	}
}

