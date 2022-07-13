package com.espinas.fhir.rest.controller;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.validation.FhirValidator;
import com.espinas.fhir.ApplicationProperties;
import com.espinas.fhir.rest.RestSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

public class BaseController extends RestSupport {

//    private FhirContext fhirContext;
//    private IParser parser;
//    private FhirValidator fhirValidator;
//
//    public FhirContext getFhirContext() {
//        if (this.fhirContext == null) {
//            this.fhirContext = new FhirContext(FhirVersionEnum.R4);
//        }
//        return fhirContext;
//    }
//
//    public IParser getIParser() {
//        if (this.parser == null) {
//            this.parser = getFhirContext().newJsonParser().setPrettyPrint(true);
//        }
//        return parser;
//    }
//
//    public FhirValidator getFhirValidator() {
//        if (this.fhirValidator == null) {
//            this.fhirValidator = getFhirContext().newValidator();
//        }
//        return fhirValidator;
//    }
}
