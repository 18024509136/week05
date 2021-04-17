package com.geek.spring.autoconfig.test.service.impl;

import com.geek.spring.autoconfig.test.bean.Klass;
import com.geek.spring.autoconfig.test.bean.Student;
import com.geek.spring.autoconfig.test.service.ISchool;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Data
public class School implements ISchool {

    @Autowired
    Klass class1;

    @Resource(name = "student001")
    Student student001;

    @Override
    public void ding() {

        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student001);

    }

}
