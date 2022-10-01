package com.fundamentals.spring.fundamentalsJavaSpringBoot;

import com.fundamentals.spring.fundamentalsJavaSpringBoot.bean.MyBean;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.bean.MyBeanWithDependency;
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
	private GeneralConfiguration generalConfiguration;

	@Autowired
	public FundamentalsJavaSpringBootApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, GeneralConfiguration generalConfiguration) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.generalConfiguration = generalConfiguration;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentalsJavaSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) {
		generalConfiguration.printFullName();
	}
}
