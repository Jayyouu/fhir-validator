package com.jhkang.fhir.rest.controller;

import ca.uhn.fhir.context.FhirContext;
import com.jhkang.fhir.rest.RestSupport;

public class BaseController extends RestSupport {
    private final FhirContext fhirContext = FhirContext.forR4();

    public FhirContext getFhirContext() {
        return fhirContext;
    }
}
