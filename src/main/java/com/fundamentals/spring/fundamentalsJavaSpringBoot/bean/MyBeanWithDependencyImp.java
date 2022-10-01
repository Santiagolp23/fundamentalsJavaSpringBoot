package com.fundamentals.spring.fundamentalsJavaSpringBoot.bean;

public class MyBeanWithDependencyImp implements MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependencyImp(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        System.out.println(myOperation.sum(1));

        System.out.println("Hi from the bean with dependency");
    }
}
