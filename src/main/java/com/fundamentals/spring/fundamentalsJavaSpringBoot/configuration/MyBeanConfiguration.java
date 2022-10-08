package com.fundamentals.spring.fundamentalsJavaSpringBoot.configuration;

import com.fundamentals.spring.fundamentalsJavaSpringBoot.bean.*;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration()
public class MyBeanConfiguration {
    @Bean
    public MyBean beanOp() {
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation OperationOp() {
        return new MyOperationImp();
    }

    @Bean
    public MyBeanWithDependency beanOp2(MyOperation myOperation) {
        return new MyBeanWithDependencyImp(myOperation);
    }

    @Bean
    public MyBeanWithProperties beanProp(GeneralConfiguration generalConfiguration) {
        return new MyBeanWithPropertiesImpl(generalConfiguration);
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:testdb");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }


}

