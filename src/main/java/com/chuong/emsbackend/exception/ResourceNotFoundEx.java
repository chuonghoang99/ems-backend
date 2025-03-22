package com.chuong.emsbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundEx extends RuntimeException {

    public ResourceNotFoundEx(String message) {
        super(message);
    }
}
