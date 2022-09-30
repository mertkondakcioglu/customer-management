package com.qnbeyond.customermanagement.common.config;

import com.qnbeyond.customermanagement.common.filter.ApiRequestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiLoggerConfig {

    @Bean
    public FilterRegistrationBean<ApiRequestFilter> apiRequestFilterRegistrationBean(ApiRequestFilter filter) {
        FilterRegistrationBean<ApiRequestFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/api/v1/*");

        return registrationBean;
    }
}
