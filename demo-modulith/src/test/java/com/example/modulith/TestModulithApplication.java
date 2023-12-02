package com.example.modulith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestModulithApplication {

  public static void main(String[] args) {
    SpringApplication.from(ModulithApplication::main).with(TestModulithApplication.class).run(args);
  }
}
