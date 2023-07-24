package com.ecommerce.backend.exception;

public class BadRequestException extends RuntimeException {


    public BadRequestException(String msg){
        super(msg);
    }
    public BadRequestException(String msg, Exception ex){
        super(msg,ex);
    }
}
