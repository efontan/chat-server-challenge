package challenge.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import challenge.controller.filter.AuthFilter;

@Configuration
public class FilterConfig {
    
    @Autowired
    private AuthFilter authFilter;
    
    @Bean
    public FilterRegistrationBean configAuthFilter() {
        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
        
        registrationBean.setFilter(authFilter);
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/messages/*");
        
        return registrationBean;
    }
}
