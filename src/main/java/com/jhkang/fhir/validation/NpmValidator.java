package com.jhkang.fhir.validation;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.validation.FhirValidator;
import ca.uhn.fhir.validation.SingleValidationMessage;
import ca.uhn.fhir.validation.ValidationResult;
import org.hl7.fhir.common.hapi.validation.support.*;
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator;
import org.hl7.fhir.instance.model.api.IBaseResource;

public class NpmValidator {

    public void npm(String fhirResource) throws Exception {
        FhirContext fhirContext = FhirContext.forR4();

        NpmPackageValidationSupport npmPackageSupport = new NpmPackageValidationSupport(fhirContext);
        npmPackageSupport.loadPackageFromClasspath("classpath:fhir/package/iteyes.myhw.core-1.0.4-beta.tgz");

        ValidationSupportChain validationSupportChain = new ValidationSupportChain(
                npmPackageSupport,
                new DefaultProfileValidationSupport(fhirContext),
                new CommonCodeSystemsTerminologyService(fhirContext),
                new InMemoryTerminologyServerValidationSupport(fhirContext),
                new SnapshotGeneratingValidationSupport(fhirContext)
        );
        CachingValidationSupport validationSupport = new CachingValidationSupport(validationSupportChain);

        FhirValidator validator = fhirContext.newValidator();
        FhirInstanceValidator instanceValidator = new FhirInstanceValidator(validationSupport);
        validator.registerValidatorModule(instanceValidator);

        IParser parser = fhirContext.newJsonParser().setPrettyPrint(true);
        IBaseResource resource = parser.parseResource(fhirResource);
        String serialized = parser.encodeResourceToString(resource);
        System.out.println(serialized);

        ValidationResult result = validator.validateWithResult(serialized);
        System.out.println(result.isSuccessful()); // false

        for (SingleValidationMessage next : result.getMessages()) {
            System.out.println(" Next issue " + next.getSeverity() + " - " + next.getLocationString() + " - " + next.getMessage());
        }
    }
}