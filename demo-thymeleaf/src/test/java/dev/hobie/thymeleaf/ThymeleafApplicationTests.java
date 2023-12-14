package dev.hobie.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ThymeleafApplicationTests {

  @Test
  void contextLoads() {
    assertEquals(Duration.ofDays(7).toSeconds(), 7 * 24 * 60 * 60);
  }
}
