### Spring Boot

https://www.tutorialspoint.com/spring_boot/spring_boot_introduction.htm
https://www.tutorialspoint.com/spring/index.htm

Spring boot is used to create microservices.
It helps build stand-alone prod ready services.

+ It automatically configures application based on added dependencies using the annotation **@EnableAutoConfiguration**.
+ The entry point of a spring boot application is the class that contains **@SpringBootApplication** and the main method.
**@SpringBootApplication** already has auto configuration, so if it is already added to a class, **@EnableAutoConfiguration**,
**@ComponentScan**,**@SpringBootConfiguration** is not required.
+ Spring boot automatically scans all components in an application using **@ComponentScan** annotation. It scans all beans and packages
when an application initializes.
 
#### Spring boot Starters

They help with the dependancy management problem. e.g. : for JPA - spring-boot-starter-data-jpa
All of them follow the naming pattern spring-boot-starter-data-*.

|Name|Purpose|Dependency|
|----|-------|----------|
|Spring Boot Starter Actuator|Monitor app|spring-boot-starter-actuator|
|Spring Boot Starter Security |Spring security|spring-boot-starter-security |
|Spring Boot Starter Web |To write rest endpoints|spring-boot-starter-web |
|Spring Boot Starter ThymeLeaf |To create web apps|spring-boot-starter-thymeleaf |
|Spring Boot Starter Test |To write test cases|spring-boot-starter-test |

```maven
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

