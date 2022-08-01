package com.espinas.fhir.rest.controller.api.validation;

import com.espinas.fhir.ApplicationProperties;
import com.espinas.fhir.rest.controller.BaseController;
import com.espinas.fhir.rest.dto.response.Response;
import com.espinas.fhir.service.validation.ValidationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/validate")
@RestController
@Slf4j
public class ValidationController extends BaseController {

    private final ValidationService validationService;
    private final ApplicationProperties applicationProperties;

    @PostMapping
    public ResponseEntity<Response> validateResource(
            @RequestBody String resource) throws Exception {
        return response(validationService.validateResource(resource, applicationProperties.getProfile().getVersion()));
    }
}
