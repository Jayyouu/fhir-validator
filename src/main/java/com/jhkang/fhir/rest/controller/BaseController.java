package com.jhkang.fhir.rest.controller;

import ca.uhn.fhir.context.FhirContext;

public class BaseController {
    private final FhirContext fhirContext = FhirContext.forR4();

    public FhirContext getFhirContext() {
        return fhirContext;
    }
}
