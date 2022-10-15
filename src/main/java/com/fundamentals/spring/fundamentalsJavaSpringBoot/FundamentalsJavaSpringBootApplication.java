package com.fundamentals.spring.fundamentalsJavaSpringBoot;

import com.fundamentals.spring.fundamentalsJavaSpringBoot.bean.MyBean;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.bean.MyBeanWithDependency;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.bean.MyBeanWithProperties;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.component.ComponentDependency;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.entity.User;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.pojo.UserPojo;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.repository.UserRepository;
import com.fundamentals.spring.fundamentalsJavaSpringBoot.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentalsJavaSpringBootApplication implements CommandLineRunner {

    private final Log LOGGER = LogFactory.getLog(FundamentalsJavaSpringBootApplication.class);

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
    private MyBeanWithProperties myBeanWithProperties;
    private UserPojo userPojo;
    private UserRepository userRepository;
    private UserService userService;


    @Autowired
    public FundamentalsJavaSpringBootApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository, UserService userService) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentalsJavaSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) {
        saveUserInDataBase();
        saveWithErrorTransactional();
    }

    private void saveUserInDataBase() {
        User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
        User user2 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
        User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
        User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
        User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
        User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
        User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2021, 11, 12));
        User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2021, 2, 27));
        User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2021, 4, 10));
        User user10 = new User("Paola", "paola2@domain.com", LocalDate.of(2021, 4, 10));
        List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
        userRepository.saveAll(list);
    }

    private void saveWithErrorTransactional() {
        User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
        User test2 = new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
        User test3 = new User("TestTransactional3", "TestTransactional1@domain.com", LocalDate.now());
        User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());

        List<User> users = Arrays.asList(test1, test2, test3, test4);

        try {
            userService.saveTransactional(users);

        } catch (Exception e) {LOGGER.error("this in an exception inside the transactional method: " + e);}



        userService.getAllUsers().forEach(user -> LOGGER.info("this is the user inside the transactional method: " + user));





    }

    public void getInformationJpql() {
        LOGGER.info("User with the method getInformationJpql" +
                userRepository.findByUserEmail("paola@domain.com")
                        .orElseThrow(() -> new RuntimeException("User couldn't be found")));
    }

    public void findByNameSorted() {
        LOGGER.info("users found by name and sorted: " + userRepository.findByNameOrderByNameAsc("Paola"));
    }

    public void previousExamples() {
        myBeanWithDependency.printWithDependency();
        myBeanWithProperties.printName();
        saveUserInDataBase();
        getInformationJpql();
        findByNameSorted();
        userRepository.findByNameContainingAndBirthDateBetween("i", LocalDate.of(2021, 6, 1), LocalDate.of(2021, 9, 30)).forEach(u -> LOGGER.info(("user findByNameContainingAndBirthDateBetween: " + u)));
        LOGGER.info("User gotten by getAllByBirthDateAndEmail method: " + userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021, 3, 13), "john@domain.com").orElseThrow(() -> new RuntimeException("User couldn't be found")));

        try {
            int value = 10 / 0;
            LOGGER.debug("My value is; " + value);
        } catch (Exception e) {
            LOGGER.error("This is an error for diving by 0 " + e.getMessage());
        }
    }
}
