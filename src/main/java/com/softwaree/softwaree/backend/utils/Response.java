package com.softwaree.softwaree.backend.utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Response {
    private String message;
    private int OK;

    public Response(int ok) {
        this.message = "OK";
        this.OK = 1;
    }

    public String getMessage() {
        return message;
    }

    public int getOK() {
        return OK;
    }

    public void setOK(int OK) {
        this.OK = OK;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
