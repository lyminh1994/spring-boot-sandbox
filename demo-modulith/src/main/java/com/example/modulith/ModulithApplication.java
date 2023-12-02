package com.example.modulith;

import com.example.modulith.product.ProductService;
import com.example.modulith.product.internal.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ModulithApplication {

  public static void main(String[] args) {
    SpringApplication.run(ModulithApplication.class, args)
        .getBean(ProductService.class)
        .create(new Product("baeldung", "course", 10));
  }
}
