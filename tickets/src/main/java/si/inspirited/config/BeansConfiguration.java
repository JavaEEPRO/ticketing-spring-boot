package si.inspirited.config;

import org.apache.logging.log4j.Level;
//import org.apache.taglibs.standard.tag.common.fmt.BundleSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.boot.autoconfigure.http.HttpProperties;
//import org.springframework.boot.autoconfigure.http.HttpProperties .http.HttpEncodingProperties;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafTemplateAvailabilityProvider;
import org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySources;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import si.inspirited.ejb.UserManagerBean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.Iterator;
import java.util.Locale;
//import org.springframework.http.

@Configuration
public class BeansConfiguration {

    @Bean
    public MessageSourceProperties messageSourceProperties() {
        return new MessageSourceProperties();
    }

    @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:/messages/resourcebundles/messages", "classpath:/messages", "classpath:/resourcebundles/messages" , "classpath:/messages/messages" , "messages/messages" , "/messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(5);
        return messageSource;
    }



    /*
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        final PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setPropertySources(new PropertySources() {
            @Override
            public boolean contains(String s) {
                return false;
            }

            @Override
            public PropertySource<?> get(String s) {
                return null;
            }

            @Override
            public Iterator<PropertySource<?>> iterator() {
                return null;
            }
        });
    }

*/



  //  @Autowired
  //  private HttpProperties httpEncodingProperties;

  /*  @Bean
    public OrderedCharacterEncodingFilter characterEncodingFilter() {
        OrderedCharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filter;
    }
*/
    /*@Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        return templateEngine;
    }
*/
    /*@Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver() {
        SpringResourceTemplateResolver templateResolver
                = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        //templateResolver.setSuffix(".html");
        //templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }*/
/*
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();

        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }*/

    @Bean
    public LoggerManager loggerManager() {
        LoggerManager factory = new LoggerManager();
        return factory;
    }

    //@Bean
   /* public MessageSource messageSource() {
        MessageSource source =  new org.springframework.context.support.ResourceBundleMessageSource();
        //((ResourceBundleMessageSource) source).setBundleClassLoader("classpath*:resourcebundles/messages");
        ((ResourceBundleMessageSource) source).setBundleClassLoader(ResourceBundleMessageSource.class.getClassLoader());
        return source;
    }*/

    @ComponentScan
    @Stateless
    @LocalBean
    private static class LoggerManager {

    }


}
