package com.Steven.university.model;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class PushNotification extends Notification {

    private String deviceToken;

    public PushNotification() {}

    public PushNotification(String code, String recipient, String message, LocalDateTime sendDate, NotificationStatus status, NotificationSituation situation, String deviceToken) {
        super(code, recipient, message, sendDate, status, situation);
        this.deviceToken = deviceToken;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
