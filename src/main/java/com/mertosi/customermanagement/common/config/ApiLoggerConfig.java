package com.mertosi.customermanagement.common.config;

import com.mertosi.customermanagement.common.filter.ApiLogRequestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiLoggerConfig {

    @Bean
    public FilterRegistrationBean<ApiLogRequestFilter> apiLogRequestFilterRegistrationBean(ApiLogRequestFilter filter) {
        FilterRegistrationBean<ApiLogRequestFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/api/v1/*");

        return registrationBean;
    }
}
