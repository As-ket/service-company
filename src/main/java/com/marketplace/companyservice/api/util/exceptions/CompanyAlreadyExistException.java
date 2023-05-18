package com.marketplace.companyservice.api.util.exceptions;

/**
 * Исключение при наличии компании в базе
 */

public class CompanyAlreadyExistException extends RuntimeException{
    
    public CompanyAlreadyExistException(String msg) {
        super(msg);
    }
}
