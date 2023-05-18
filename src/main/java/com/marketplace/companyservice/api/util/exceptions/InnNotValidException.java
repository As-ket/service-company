package com.marketplace.companyservice.api.util.exceptions;

/**
 * Исключение для невалидного инн
 */

public class InnNotValidException extends RuntimeException{
    
    public InnNotValidException(String msg) {
        super(msg);
    }
}