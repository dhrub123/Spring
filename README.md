### Spring Boot

https://www.tutorialspoint.com/spring_boot/spring_boot_introduction.htm<br />
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
|Spring Boot Starter Parent|----|spring-boot-starter-parent|
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

To create a rest endpoint, we have to annotate class with **@RestController**
and method with **@RequestMapping(value = "/")**. Value will be taking the path.

To deploy the spring boot application as a war file, few things need to be done.
+ The main class must extend **SpringBootServletInitializer** and 
  override configure() method
+ In maven we will need to define the start class
+ we will need to update packaging to war

```maven
<properties>
   <start-class>com.dhruba.DemoApplication</start-class>
</properties>

<packaging>war</packaging>
```

```java
SpringBootApplication
@RestController
public class DemoApplication  extends SpringBootServletInitializer {
   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      return application.sources(DemoApplication.class);
   }
   public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
   }
   
   @RequestMapping(value = "/")
   public String hello() {
      return "Hello World from Tomcat";
   }
}
```

#### Dependency Injection and autowiring in Spring Boot

We create beans like below.
```java
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
```

Then we autowire them.
```java
	@Autowired
	RestTemplate restTemplate;
```

#### Spring runners

Spring Boot Runners, ApplicationRunner and CommandLineRunner lets us execute code 
immediately after the spring boot application has started. We implement the ApplicationRunner
or the CommandLineRunner interface adn override the run method for this.

```java
   @Override
   public void run(ApplicationArguments arg0) throws Exception {
      System.out.println("Hello World from Application Runner");
   }
   
   @Override
   public void run(String... arg0) throws Exception {
      System.out.println("Hello world from Command Line Runner");
   }
```

### Application Properties

#### Command Line Properties
Pass Command line arguments like 
```java
java -jar demo.jar --server.port=9090
```

#### Properties File
Keep application.properties or application.yml under src/main/resources 
```java
spring:
   application:
      name: demoservice
server:
   port: 9090
```
#### Externalized Properties
If we want to keep properties in a different location apart from src/main/resources 
we can use -Dspring.config.location = C:\application.properties

#### Reading properties
The @Value annotation is used.
```java
@Value("${spring.application.name}")
```

#### Spring profiles
Spring profiles can be used to read property files of different environments.
The property files are named like application.properties, application-dev.properties and application-prod.properties
For yml, one file is sufficient.
The settings for different profiles are separated by a delimter ---.
```java
spring:
   profiles: dev
   application:
     name: demoservice
server:
   port: 9090
---
spring:
   profiles: dev
   application:
     name: demoservice
server:
   port: 7070
```
Then when executing program, the active profile is passed as a command line argument.
```java
java -jar demo.jar --spring.profiles.active=dev
```
