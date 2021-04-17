package com.geek.spring.autoconfig.test.config;

import com.geek.spring.autoconfig.test.bean.Klass;
import com.geek.spring.autoconfig.test.bean.Student;
import com.geek.spring.autoconfig.test.service.impl.School;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangxiaodi
 * @since 2021-04-16 09:11
 */

@Configuration
public class AutoConfigTest {

    @Bean(name = "student001")
    public Student getFirstStudent() {
        return new Student(1, "student001");
    }

    @Bean(name = "student002")
    public Student getSecondStudent() {
        return new Student(2, "student002");
    }

    @Bean
    public Klass getKlass() {
        List<Student> students = new ArrayList<>(2);
        students.add(this.getFirstStudent());
        students.add(this.getSecondStudent());

        Klass klass = new Klass();
        klass.setStudents(students);
        return klass;
    }

    @Bean
    public School getSchool() {
        School school = new School();
        Klass klass = this.getKlass();
        school.setClass1(klass);
        school.setStudent001(this.getFirstStudent());
        return school;
    }
}
