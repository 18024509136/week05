package com.geek.spring.beanassembletest.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huangxiaodi
 * @since 2021-04-16 17:35
 */
public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        DemoController controllerBean = context.getBean(DemoController.class);
        controllerBean.doSomething();

        context.registerShutdownHook();
    }
}
