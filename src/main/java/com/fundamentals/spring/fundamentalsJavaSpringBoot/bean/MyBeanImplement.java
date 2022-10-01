package com.fundamentals.spring.fundamentalsJavaSpringBoot.bean;

public class MyBeanImplement implements MyBean{
    @Override
    public void print() {
        System.out.println("Hello from the implementation of my own Bean");
    }
}
