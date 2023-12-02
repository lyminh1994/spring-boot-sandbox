package com.example.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext
class ModulithApplicationTests {

  @Test
  void createApplicationModuleModel() {
    ApplicationModules modules = ApplicationModules.of(ModulithApplication.class);
    modules.forEach(System.out::println);
  }

  @Test
  void verifiesModularStructure() {
    ApplicationModules modules = ApplicationModules.of(ModulithApplication.class);
    modules.verify();
  }

  @Test
  void createModuleDocumentation() {
    ApplicationModules modules = ApplicationModules.of(ModulithApplication.class);
    new Documenter(modules).writeDocumentation().writeIndividualModulesAsPlantUml();
  }
}
