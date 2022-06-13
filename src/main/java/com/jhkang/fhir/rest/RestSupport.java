package com.jhkang.fhir.rest;

import com.jhkang.fhir.rest.dto.response.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.nio.charset.StandardCharsets;

public abstract class RestSupport {
    final MediaType MEDIA_TYPE_APPLICATION_JSON_UTF8 = new MediaType("application", "json", StandardCharsets.UTF_8);

    protected <T> ResponseEntity<Response> response(T data) {
        return ResponseEntity
                .ok()
                .contentType(MEDIA_TYPE_APPLICATION_JSON_UTF8)
                .body(new Response(200, data, "Ok"));
    }

    protected <T> ResponseEntity<Response> response_201(T data) {
        return ResponseEntity
                .ok()
                .contentType(MEDIA_TYPE_APPLICATION_JSON_UTF8)
                .body(new Response(201, data, "CREATED"));
    }

    protected <T> ResponseEntity<Response> response_404(T data) {
        return ResponseEntity
                .ok()
                .contentType(MEDIA_TYPE_APPLICATION_JSON_UTF8)
                .body(new Response(404, null, "ERROR"));
    }

    protected <T> ResponseEntity<Response> response_500(T data) {
        return ResponseEntity
                .ok()
                .contentType(MEDIA_TYPE_APPLICATION_JSON_UTF8)
                .body(new Response(400, null, "ERROR"));
    }

}
