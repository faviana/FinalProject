package ironyard.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by favianalopez on 11/15/16.
 */
@Configuration
public class FilterRegistrations {

    /**
     * mvs security filter added to path: /event/*
     * @return returns FilterRegistrationBean
     */


    @Bean
    public FilterRegistrationBean securityFilter(){
        FilterRegistrationBean registrationsBean= new FilterRegistrationBean(new SecurityFilter());
        registrationsBean.addUrlPatterns("/event/*");

        return registrationsBean;
    }

    /**
     * rest security filter added to path: /rest/*
     * @return returns FilterRegistrationBean
     */

    @Bean
    public FilterRegistrationBean restApiFilter() {
        /**
         * Apply RestSecurityFilter filter to any request that matches /rest/*
         */
        FilterRegistrationBean registration = new FilterRegistrationBean(new RestSecurityFilter());
        registration.addUrlPatterns("/rest/*");
        return registration;
    }
}