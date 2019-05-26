package com.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.spring")
@RestController
public class MainApplication extends SpringBootServletInitializer {

  private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

  public static void main(String[] args) {
    logger.info("this is a info message");
    logger.warn("this is a warn message");
    logger.error("this is a error message");
    SpringApplication.run(MainApplication.class, args);
  }

  /**
   * The @Value annotation is used to read the environment or application property value in Java
   * code
   */
  @Value("${spring.application.name}")
  private String name;

  @RequestMapping(value = "/")
  public String name() {
    return name;
  }
}
