package com.example.modulith.notification;

import com.example.modulith.notification.internal.Notification;
import com.example.modulith.notification.internal.NotificationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {

  @Async
  @ApplicationModuleListener
  public void notificationEvent(NotificationDTO event) {
    Notification notification = toEntity(event);
    log.info(
        "Received notification by event for product {} in date {} by {}.",
        notification.getProductName(),
        notification.getDate(),
        notification.getFormat());
  }

  private Notification toEntity(NotificationDTO event) {
    return new Notification(
        event.productName(), event.date(), NotificationType.valueOf(event.format()));
  }
}
