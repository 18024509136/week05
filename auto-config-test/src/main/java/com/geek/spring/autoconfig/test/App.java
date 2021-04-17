package com.geek.spring.autoconfig.test;

import com.geek.spring.autoconfig.test.service.impl.School;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author huangxiaodi
 * @since 2021-04-16 09:10
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        School school = context.getBean(School.class);
        school.ding();
    }
}
