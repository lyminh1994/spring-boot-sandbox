package com.example.modulith.notification.internal;

import lombok.Data;

import java.util.Date;

@Data
public class Notification {

  private String productName;
  private Date date;
  private NotificationType format;

  public Notification(Date date, NotificationType format, String productName) {
    this.productName = productName;
    this.date = date;
    this.format = format;
  }
}
