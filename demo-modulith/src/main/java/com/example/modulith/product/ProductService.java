package com.example.modulith.product;

import com.example.modulith.notification.NotificationDTO;
import com.example.modulith.product.internal.Product;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ApplicationEventPublisher events;

  public void create(Product product) {
    events.publishEvent(new NotificationDTO(new Date(), "SMS", product.getName()));
  }
}
