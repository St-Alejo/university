package com.Steven.university.service;

import com.Steven.university.model.EmailNotification;
import com.Steven.university.model.Notification;
import com.Steven.university.model.NotificationStatus;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(Notification notification) {
        EmailNotification emailNotification = (EmailNotification) notification;
        // Logic to send email (e.g. JavaMailSender)
        System.out.println("Enviando Email a: " + emailNotification.getRecipient());
        System.out.println("Asunto: " + emailNotification.getSubject());
        System.out.println("Mensaje: " + emailNotification.getMessage());
        
        emailNotification.setStatus(NotificationStatus.SENT);
    }

    @Override
    public boolean supports(Class<? extends Notification> notificationClass) {
        return EmailNotification.class.isAssignableFrom(notificationClass);
    }
}
