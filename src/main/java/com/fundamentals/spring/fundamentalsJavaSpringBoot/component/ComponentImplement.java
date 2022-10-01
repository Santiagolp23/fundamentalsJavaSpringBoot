package com.fundamentals.spring.fundamentalsJavaSpringBoot.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency {

    @Override
    public void salute() {
        System.out.println("Hello world from the component");
    }
}
