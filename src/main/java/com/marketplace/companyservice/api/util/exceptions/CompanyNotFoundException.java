package com.marketplace.companyservice.api.util.exceptions;

/**
 * Исключение при отсутствии компании с ID, передаваемым
 * при добавлении картинки-аватарки
 */
public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(String msg) {
        super(msg);
    }
}
