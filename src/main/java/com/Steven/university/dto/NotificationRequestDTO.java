package com.Steven.university.dto;

import com.Steven.university.model.NotificationSituation;

public class NotificationRequestDTO {

    private String type;
    private String code;
    private String recipient;
    private String message;
    private NotificationSituation situation;
    
    // For Email
    private String subject;
    private String cc;
    
    // For SMS
    private String phoneNumber;
    
    // For Push
    private String deviceToken;

    public NotificationRequestDTO() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationSituation getSituation() {
        return situation;
    }

    public void setSituation(NotificationSituation situation) {
        this.situation = situation;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
