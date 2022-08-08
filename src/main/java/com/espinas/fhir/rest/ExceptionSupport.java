package com.espinas.fhir.rest;

import com.espinas.fhir.rest.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.nio.charset.StandardCharsets;

public abstract class ExceptionSupport {
    final MediaType MEDIA_TYPE_APPLICATION_JSON_UTF8 = new MediaType("application", "json", StandardCharsets.UTF_8);

    protected <T> ResponseEntity<ErrorResponse> errorResponse(HttpStatus httpStatusCode, Throwable throwable) {
        return ResponseEntity
                .status(httpStatusCode)
                .contentType(MEDIA_TYPE_APPLICATION_JSON_UTF8)
                .body(new ErrorResponse(httpStatusCode.value(), throwable.toString(), throwable.getMessage()));
    }
}
