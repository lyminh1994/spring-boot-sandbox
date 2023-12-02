package com.example.modulith.notification.internal;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

  private String productName;
  private Date date;
  private NotificationType format;
}
