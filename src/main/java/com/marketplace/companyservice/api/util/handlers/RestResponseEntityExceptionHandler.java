package com.marketplace.companyservice.api.util.handlers;

import com.marketplace.companyservice.api.util.exceptions.CompanyAlreadyExistException;
import com.marketplace.companyservice.api.util.exceptions.InnNotValidException;
import com.marketplace.companyservice.api.util.exceptions.InvalidSizeDocAttachException;
import com.marketplace.companyservice.api.util.exceptions.InvalidTypeDocAttachException;
import com.marketplace.companyservice.api.util.exceptions.CompanyNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * Перехват исключений
 */

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {InvalidSizeDocAttachException.class})
    public ResponseEntity<String> invalidSizeDocAttach(RuntimeException ex) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InvalidTypeDocAttachException.class})
    public ResponseEntity<String> invalidTypeDocAttach(RuntimeException ex) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {CompanyNotFoundException.class})
    public ResponseEntity<String> companyNotFound(RuntimeException ex) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { CompanyAlreadyExistException.class })
    public ResponseEntity<String> companyExist(RuntimeException ex) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { InnNotValidException.class })
    public ResponseEntity<String> innOccupied(RuntimeException ex) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}