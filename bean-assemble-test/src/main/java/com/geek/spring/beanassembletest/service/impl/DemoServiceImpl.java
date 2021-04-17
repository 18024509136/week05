package com.geek.spring.beanassembletest.service.impl;

import com.geek.spring.beanassembletest.service.DemoService;
import com.geek.spring.beanassembletest.service.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangxiaodi
 * @since 2021-04-16 16:23
 */
@Service("demoService2")
public class DemoServiceImpl implements DemoService {

    @Autowired
    private Tool tool;

    @Override
    public void run() {
        System.out.println("tool对象：" + tool);
        tool.work();
    }
}
