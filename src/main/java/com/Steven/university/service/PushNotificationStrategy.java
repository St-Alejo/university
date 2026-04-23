package com.Steven.university.service;

import com.Steven.university.model.Notification;
import com.Steven.university.model.NotificationStatus;
import com.Steven.university.model.PushNotification;
import org.springframework.stereotype.Component;

@Component
public class PushNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(Notification notification) {
        PushNotification pushNotification = (PushNotification) notification;
        // Logic to send Push Notification (e.g. Firebase Cloud Messaging)
        System.out.println("Enviando Notificación Push al dispositivo: " + pushNotification.getDeviceToken());
        System.out.println("Mensaje: " + pushNotification.getMessage());
        
        pushNotification.setStatus(NotificationStatus.SENT);
    }

    @Override
    public boolean supports(Class<? extends Notification> notificationClass) {
        return PushNotification.class.isAssignableFrom(notificationClass);
    }
}
