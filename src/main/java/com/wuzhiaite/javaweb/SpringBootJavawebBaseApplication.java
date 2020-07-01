package com.wuzhiaite.javaweb;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @description  启动类
 * @author lpf
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
@EnableTransactionManagement
@EnableCaching
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableRabbit

public class SpringBootJavawebBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJavawebBaseApplication.class, args);
    }







}
