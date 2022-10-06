package com.fundamentals.spring.fundamentalsJavaSpringBoot.bean;

import com.fundamentals.spring.fundamentalsJavaSpringBoot.configuration.GeneralConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBeanWithPropertiesImpl implements MyBeanWithProperties {
    String name;
    String lastname;
    private GeneralConfiguration generalConfiguration;

    @Autowired
    public MyBeanWithPropertiesImpl(GeneralConfiguration generalConfiguration) {
        this.generalConfiguration = generalConfiguration;
        this.name = generalConfiguration.getName();
        this.lastname = generalConfiguration.getLastName();
    }

    @Override
    public void printName() {
        System.out.println(name + " " + lastname);
    }
}
