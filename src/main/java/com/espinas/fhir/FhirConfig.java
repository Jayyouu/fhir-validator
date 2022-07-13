package com.espinas.fhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.validation.FhirValidator;
import org.hl7.fhir.common.hapi.validation.support.*;
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator;

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

    public static FhirValidator getFhirValidator(String packageVersion) throws Exception {
        if (fhirValidator == null) {
            fhirValidator = getFhirContext().newValidator();

            // Customized Validation SupportChain
            ValidationSupportChain validationSupportChain = setNpmPackageValidationSupportChain(getFhirContext(), packageVersion);
            CachingValidationSupport validationSupport = new CachingValidationSupport(validationSupportChain);
            FhirInstanceValidator instanceValidator = new FhirInstanceValidator(validationSupport);

            fhirValidator.registerValidatorModule(instanceValidator);
        }
        return fhirValidator;
    }

    private static ValidationSupportChain setNpmPackageValidationSupportChain(FhirContext fhirContext, String packageVersion) throws Exception {

        NpmPackageValidationSupport npmPackageSupport = new NpmPackageValidationSupport(fhirContext);
        npmPackageSupport.loadPackageFromClasspath("classpath:fhir/package/iteyes.myhw.core-" + packageVersion + ".tgz");

        return new ValidationSupportChain(
                npmPackageSupport,
                new DefaultProfileValidationSupport(fhirContext),
                new CommonCodeSystemsTerminologyService(fhirContext),
                new InMemoryTerminologyServerValidationSupport(fhirContext),
                new SnapshotGeneratingValidationSupport(fhirContext)
        );
    }
}
