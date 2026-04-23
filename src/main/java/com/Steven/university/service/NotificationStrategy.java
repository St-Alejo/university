package com.Steven.university.service;

import com.Steven.university.model.Notification;

public interface NotificationStrategy {
    void send(Notification notification);
    boolean supports(Class<? extends Notification> notificationClass);
}
