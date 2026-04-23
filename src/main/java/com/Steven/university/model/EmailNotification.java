package com.Steven.university.model;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class EmailNotification extends Notification {

    private String subject;
    private String cc;

    public EmailNotification() {}

    public EmailNotification(String code, String recipient, String message, LocalDateTime sendDate, NotificationStatus status, NotificationSituation situation, String subject, String cc) {
        super(code, recipient, message, sendDate, status, situation);
        this.subject = subject;
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}
