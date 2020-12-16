package com.example.cms.config;

import com.example.cms.filter.CustomFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomFilterConfiguration {
    @Bean
    public FilterRegistrationBean<CustomFilter> registrationBean() {
        FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CustomFilter());
        //Will be called whenever that url is put
        registrationBean.addUrlPatterns("/customers/*");

        return registrationBean;
    }

}
