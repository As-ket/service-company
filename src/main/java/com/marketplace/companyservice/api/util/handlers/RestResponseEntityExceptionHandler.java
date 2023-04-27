package com.marketplace.companyservice.api.util.handlers;

import com.marketplace.companyservice.api.util.exceptions.CompanyNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Перехват исключений
 */
@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CompanyNotFoundException.class})
    public ResponseEntity<String> companyNotFound(RuntimeException ex) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
