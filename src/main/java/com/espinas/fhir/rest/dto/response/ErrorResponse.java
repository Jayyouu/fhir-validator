package com.espinas.fhir.rest.dto.response;

import lombok.Data;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
public class ErrorResponse {
    private ZonedDateTime timestamp;
    private int code;
    private String message;
    private String detail;

    public ErrorResponse(int code, String errorMessage, String errorDetail) {
        this.timestamp = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        this.code = code;
        this.message = errorMessage;
        this.detail = errorDetail;
    }
}
