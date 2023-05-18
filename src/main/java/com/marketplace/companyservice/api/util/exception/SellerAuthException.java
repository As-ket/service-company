package com.marketplace.companyservice.api.util.exception;

import feign.FeignException;

/**
 * Исключение при наличии в базе auth-service компании в момент отправления данных в бд company
 */

public class SellerAuthException extends FeignException {
    public SellerAuthException(int message, String cause) {
        super(message, cause);
    }
}
