package com.wuzhiaite.javaweb.base.config;

import com.wuzhiaite.javaweb.base.properties.BaseProperties;
import com.wuzhiaite.javaweb.base.servlet.XxsAndSqlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Filter;

@Configuration
public class BaseServletConfig {

    @Autowired
    private BaseProperties baseProperties;

    @Bean
    public FilterRegistrationBean baseFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new XxsAndSqlFilter());
        bean.setUrlPatterns(baseProperties.getFilterUrl());
        return bean ;
    }





}