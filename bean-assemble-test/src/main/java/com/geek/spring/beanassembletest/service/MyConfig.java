package com.geek.spring.beanassembletest.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangxiaodi
 * @since 2021-04-16 16:53
 */
@Configuration
public class MyConfig {

    @Bean
    public Person getPerson() {
        return new Person("小明");
    }
}
