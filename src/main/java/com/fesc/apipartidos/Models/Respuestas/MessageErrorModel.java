package com.fesc.apipartidos.Models.Respuestas;

import java.util.Date;

public class MessageErrorModel {
    
    private Date Timestamp;

    private String message;


    public MessageErrorModel() {
    }


    public MessageErrorModel(Date timestamp, String message) {
        Timestamp = timestamp;
        this.message = message;
    }


    public Date getTimestamp() {
        return Timestamp;
    }
    public void setTimestamp(Date timestamp) {
        Timestamp = timestamp;
    }


    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}