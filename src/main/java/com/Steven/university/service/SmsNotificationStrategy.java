package com.Steven.university.service;

import com.Steven.university.model.Notification;
import com.Steven.university.model.NotificationStatus;
import com.Steven.university.model.SmsNotification;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(Notification notification) {
        SmsNotification smsNotification = (SmsNotification) notification;
        // Logic to send SMS (e.g. Twilio)
        System.out.println("Enviando SMS al número: " + smsNotification.getPhoneNumber());
        System.out.println("Mensaje: " + smsNotification.getMessage());
        
        smsNotification.setStatus(NotificationStatus.SENT);
    }

    @Override
    public boolean supports(Class<? extends Notification> notificationClass) {
        return SmsNotification.class.isAssignableFrom(notificationClass);
    }
}
