package com.Steven.university.service;

import com.Steven.university.model.Notification;
import com.Steven.university.model.NotificationStatus;
import com.Steven.university.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final List<NotificationStrategy> strategies;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, List<NotificationStrategy> strategies) {
        this.notificationRepository = notificationRepository;
        this.strategies = strategies;
    }

    public Notification processAndSendNotification(Notification notification) {
        notification.setSendDate(LocalDateTime.now());
        notification.setStatus(NotificationStatus.PENDING);
        
        Notification savedNotification = notificationRepository.save(notification);

        for (NotificationStrategy strategy : strategies) {
            if (strategy.supports(savedNotification.getClass())) {
                try {
                    strategy.send(savedNotification);
                } catch (Exception e) {
                    savedNotification.setStatus(NotificationStatus.FAILED);
                }
                return notificationRepository.save(savedNotification);
            }
        }
        
        throw new IllegalArgumentException("No support found for notification type: " + notification.getClass());
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
