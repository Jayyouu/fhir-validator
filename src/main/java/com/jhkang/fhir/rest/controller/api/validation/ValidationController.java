package com.jhkang.fhir.rest.controller.api.validation;

import com.jhkang.fhir.service.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/validate")
@RestController
@Slf4j
public class ValidationController {

    private final ValidationService validationService;

    @PostMapping
    public String validateResource(
            @RequestBody String resource) throws Exception {

        log.info(resource);
        validationService.validateResource(resource);

        return "a";
    }
}
