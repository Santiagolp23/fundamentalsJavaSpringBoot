package com.fundamentals.spring.fundamentalsJavaSpringBoot.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void salute() {
        System.out.println("Hello world from the second dependency!");
    }
}
