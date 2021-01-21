package com.enes.patient.exception;


public class BusinessException extends RuntimeException {

    public BusinessException(String errorMessage){
        super(errorMessage);
    }
}
