package com.geek.spring.beanassembletest.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author huangxiaodi
 * @since 2021-04-16 16:33
 */
public class DemoController implements InitializingBean, DisposableBean {

    private DemoService demoService1;

    @Resource(name = "demoService2")
    private DemoService demoService2;

    @Autowired
    private Person person;

    public void setDemoService1(DemoService demoService1) {
        this.demoService1 = demoService1;
    }

    public DemoController() {
        System.out.println("执行构造函数，成员变量：" + demoService1);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行DisposableBean回调方法，成员变量：" + demoService1);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行InitializingBean回调方法，成员变量：" + demoService1);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("执行postConstruct方法，成员变量：" + demoService1);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("执行preDestroy方法，成员变量：" + demoService1);
    }

    public void init() {
        System.out.println("执行配置文件指定的init方法，成员变量：" + demoService1);
    }

    public void cleanUp() {
        System.out.println("执行配置文件指定的destroy method，成员变量：" + demoService1);
    }

    public void doSomething() {
        demoService1.run();
        System.out.println(person.getName() + "执行了demoService1的run方法");

        demoService2.run();
        System.out.println(person.getName() + "执行了demoService2的run方法");
    }
}
