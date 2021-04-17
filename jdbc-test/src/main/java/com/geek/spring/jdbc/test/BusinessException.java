package com.geek.spring.jdbc.test;

public class BusinessException extends RuntimeException {

    public BusinessException(Throwable e) {
        super(e);
    }
}
