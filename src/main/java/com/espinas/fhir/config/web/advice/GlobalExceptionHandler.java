package com.espinas.fhir.config.web.advice;

import ca.uhn.fhir.parser.DataFormatException;
import com.espinas.fhir.exception.BadRequestException;
import com.espinas.fhir.rest.ExceptionSupport;
import com.espinas.fhir.rest.dto.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ExceptionSupport {

    @ExceptionHandler(value = {BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> BadRequest(Exception e) {
        log.info("BadRequest Exception, message: {{}}", e.getMessage());
        return errorResponse(HttpStatus.BAD_REQUEST, e);
    }

    @ExceptionHandler(value = {DataFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> DataFormatException(Exception e) {
        log.info("HAPI DataFormatException, message: {{}}", e.getMessage());
        return errorResponse(HttpStatus.BAD_REQUEST, e);
    }
}
