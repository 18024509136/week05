package com.geek.spring.beanassembletest.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author huangxiaodi
 * @since 2021-04-16 16:50
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DemoController) {
            Field field = null;
            try {
                field = bean.getClass().getDeclaredField("demoService1");
                field.setAccessible(true);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            try {
                Object o = field.get(bean);
                System.out.println("执行postProcessBeforeInitialization方法，成员变量为：" + o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DemoController) {
            Field field = null;
            try {
                field = bean.getClass().getDeclaredField("demoService1");
                field.setAccessible(true);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            try {
                Object o = field.get(bean);
                System.out.println("执行postProcessBeforeInitialization方法，成员变量为：" + o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return bean;
    }
}
