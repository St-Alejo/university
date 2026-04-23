package com.Steven.university.model;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class SmsNotification extends Notification {

    private String phoneNumber;

    public SmsNotification() {}

    public SmsNotification(String code, String recipient, String message, LocalDateTime sendDate, NotificationStatus status, NotificationSituation situation, String phoneNumber) {
        super(code, recipient, message, sendDate, status, situation);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
