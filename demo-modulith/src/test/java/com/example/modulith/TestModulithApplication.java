package com.example.modulith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestModulithApplication {

  public static void main(String[] args) {
    SpringApplication.from(ModulithApplication::main).with(TestModulithApplication.class).run(args);
  }

  @Bean
  @ServiceConnection
  MongoDBContainer mongoDbContainer() {
    return new MongoDBContainer(DockerImageName.parse("mongo:latest"));
  }

  @Bean
  @ServiceConnection(name = "openzipkin/zipkin")
  GenericContainer<?> zipkinContainer() {
    return new GenericContainer<>(DockerImageName.parse("openzipkin/zipkin:latest"))
        .withExposedPorts(9411);
  }
}
