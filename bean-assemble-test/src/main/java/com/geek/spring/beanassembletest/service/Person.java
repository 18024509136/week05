package com.geek.spring.beanassembletest.service;

/**
 * @author huangxiaodi
 * @since 2021-04-16 18:06
 */
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
