package com.jhkang.fhir.rest.controller.api.validation;

import ca.uhn.fhir.context.FhirContext;
import com.jhkang.fhir.ApplicationProperties;
import com.jhkang.fhir.rest.controller.BaseController;
import com.jhkang.fhir.rest.dto.response.Response;
import com.jhkang.fhir.service.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/validate")
@RestController
@Slf4j
public class ValidationController extends BaseController {

    private final ValidationService validationService;
    private final ApplicationProperties applicationProperties;

    @PostMapping
    public ResponseEntity<Response> validateResource(
            @RequestBody String resource) throws Exception {
        FhirContext fhirContext = getFhirContext();

        return response(validationService.validateResource(fhirContext, resource, applicationProperties.getProfile().getVersion()));
    }
}
