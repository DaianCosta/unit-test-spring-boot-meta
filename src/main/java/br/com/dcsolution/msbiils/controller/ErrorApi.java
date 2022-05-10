package br.com.dcsolution.msbiils.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ErrorApi implements Serializable {

    @JsonProperty("message")
    private final String message;

    public ErrorApi(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
