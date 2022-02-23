package hu.wup.geobookxchanger.gw.configurations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LogManager.getLogger(SecurityConfiguration.class);

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        logger.info("I am in securityConfiguration");
        httpSecurity.authorizeRequests().antMatchers("/**").permitAll();
        httpSecurity.csrf().disable();
    }
}
