package com.world.remit.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerAddrNotFoundException extends RuntimeException {

    public CustomerAddrNotFoundException(String message) {
        super(message);
    }
}
