package com.espinas.fhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.validation.FhirValidator;

public class FhirConfig {
    private static FhirContext fhirContext;
    private static IParser parser;
    private static FhirValidator fhirValidator;

    public static FhirContext getFhirContext() {
        if (fhirContext == null) {
            fhirContext = new FhirContext(FhirVersionEnum.R4);
        }
        return fhirContext;
    }

    public static IParser getIParser() {
        if (parser == null) {
            parser = getFhirContext().newJsonParser().setPrettyPrint(true);
        }
        return parser;
    }

    public static FhirValidator getFhirValidator() {
        if (fhirValidator == null) {
            fhirValidator = getFhirContext().newValidator();
        }
        return fhirValidator;
    }
}
