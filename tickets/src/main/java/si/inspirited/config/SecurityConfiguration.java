package si.inspirited.config;

import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import si.inspirited.util.logger.InjectLogger;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @InjectLogger
    public static Logger LOGGER;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("tester").password("localtest12").roles("USER").and()
                .withUser("admin").password("SaVeDbyJeSuS@2019").roles("USER","ADMIN").and()
                .withUser("root").password("SaVeDbyJeSuS@2019").roles("USER","ADMIN");

        LOGGER.info("in memory authentication (basic configuration) proceeded::success");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception {
        httpSecurity
                .authorizeRequests()

                //URLs matching for access rights
                .antMatchers("/").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/home").permitAll()//.hasAnyAuthority("SUPER_USER", "ADMIN" , "USER", "SITE_USER")
                //.anyRequest()
                //.permitAll()
                .and()

                //form login
                .csrf().disable().formLogin()
//                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/home")
                .usernameParameter("email")
                .passwordParameter("password")
                .and()

                //logout
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
                //.httpBasic();

        //httpSecurity.csrf().disable();

    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        //https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/core/userdetails/User.html
        //withDefaultPasswordEncoder()
        /** @deprecated */
        //Using this method is not considered safe for production, but is acceptable for demos and getting started. For production purposes, ensure the password is encoded externally. See the method Javadoc for additional details. There are no plans to remove this support. It is deprecated to indicate that this is considered insecure for production purposes.
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
        return manager;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}
