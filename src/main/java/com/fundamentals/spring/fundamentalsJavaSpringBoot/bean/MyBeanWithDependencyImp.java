package com.fundamentals.spring.fundamentalsJavaSpringBoot.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBeanWithDependencyImp implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImp.class);

    private MyOperation myOperation;

    @Autowired
    public MyBeanWithDependencyImp(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Whe have entered to the method printWithDependency");

        int number = 1;
        LOGGER.debug("The number sent as parameter to the dependency is: " + number);
        System.out.println(myOperation.sum(number));
        System.out.println("Hi from the bean with dependency");
    }
}
