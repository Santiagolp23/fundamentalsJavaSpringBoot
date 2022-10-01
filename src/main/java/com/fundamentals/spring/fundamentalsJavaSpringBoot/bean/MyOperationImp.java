package com.fundamentals.spring.fundamentalsJavaSpringBoot.bean;

public class MyOperationImp implements MyOperation{
    @Override
    public int sum(int number) {
        return number + 1;
    }
}
