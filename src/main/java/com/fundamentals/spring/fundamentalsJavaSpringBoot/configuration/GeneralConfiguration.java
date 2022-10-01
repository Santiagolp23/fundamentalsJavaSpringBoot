package com.fundamentals.spring.fundamentalsJavaSpringBoot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "person")
public class GeneralConfiguration {
    private String name;
    private String lastName;
    private String random;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String  getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public void printFullName(){
        System.out.println(name + " " + lastName);
    }
}
