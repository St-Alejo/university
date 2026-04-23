package com.Steven.university.controller;

import com.Steven.university.dto.NotificationRequestDTO;
import com.Steven.university.model.*;
import com.Steven.university.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Notification> sendNotification(@RequestBody NotificationRequestDTO request) {
        Notification notification;

        if ("EMAIL".equalsIgnoreCase(request.getType())) {
            notification = new EmailNotification(
                    request.getCode(), request.getRecipient(), request.getMessage(),
                    LocalDateTime.now(), NotificationStatus.PENDING, request.getSituation(),
                    request.getSubject(), request.getCc());
        } else if ("SMS".equalsIgnoreCase(request.getType())) {
            notification = new SmsNotification(
                    request.getCode(), request.getRecipient(), request.getMessage(),
                    LocalDateTime.now(), NotificationStatus.PENDING, request.getSituation(),
                    request.getPhoneNumber());
        } else if ("PUSH".equalsIgnoreCase(request.getType())) {
            notification = new PushNotification(
                    request.getCode(), request.getRecipient(), request.getMessage(),
                    LocalDateTime.now(), NotificationStatus.PENDING, request.getSituation(),
                    request.getDeviceToken());
        } else {
            return ResponseEntity.badRequest().build();
        }

        Notification sentNotification = notificationService.processAndSendNotification(notification);
        return ResponseEntity.ok(sentNotification);
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }
}
