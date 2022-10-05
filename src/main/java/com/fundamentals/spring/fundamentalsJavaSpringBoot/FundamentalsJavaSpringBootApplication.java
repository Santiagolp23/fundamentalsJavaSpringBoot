package com.fundamentals.spring.fundamentalsJavaSpringBoot;

import com.fundamentals.spring.fundamentalsJavaSpringBoot.bean.MyBean;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.bean.MyBeanWithDependency;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.bean.MyBeanWithProperties;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.component.ComponentDependency;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.configuration.GeneralConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentalsJavaSpringBootApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;

	@Autowired
	public FundamentalsJavaSpringBootApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentalsJavaSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) {
		myBeanWithProperties.printName();
	}
}
