package com.marketplace.companyservice.api.util.handlers;

<<<<<<< HEAD
import com.marketplace.companyservice.api.util.exceptions.InvalidSizeDocAttachException;
import com.marketplace.companyservice.api.util.exceptions.InvalidTypeDocAttachException;
=======
import com.marketplace.companyservice.api.util.exceptions.CompanyNotFoundException;
>>>>>>> 445b073 (Внесены правки.)
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
<<<<<<< HEAD
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
=======
>>>>>>> 445b073 (Внесены правки.)

/**
 * Перехват исключений
 */
<<<<<<< HEAD

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
=======
@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CompanyNotFoundException.class})
    public ResponseEntity<String> companyNotFound(RuntimeException ex) {
>>>>>>> 445b073 (Внесены правки.)
        log.info(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
