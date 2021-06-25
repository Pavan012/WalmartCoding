package com.walmart.store.drivers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.walmart.store.drivers.interceptor.DriverServiceRequestInterceptor;


@Configuration
@ComponentScan(basePackages = {"com.walmart"})
public class DriverConfig implements WebMvcConfigurer {

    @Autowired
    private DriverServiceRequestInterceptor driverServiceRequestInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(driverServiceRequestInterceptor);
    }
}
