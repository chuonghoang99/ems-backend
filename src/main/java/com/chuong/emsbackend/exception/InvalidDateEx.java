package com.chuong.emsbackend.exception;

public class InvalidDateEx extends RuntimeException {
    public InvalidDateEx(String message) {
        super(message);
    }

    public InvalidDateEx(String message, Throwable cause) {
        super(message, cause);
    }
}
