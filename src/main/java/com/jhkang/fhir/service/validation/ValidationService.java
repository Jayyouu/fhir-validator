package com.jhkang.fhir.service.validation;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.validation.SingleValidationMessage;
import ca.uhn.fhir.validation.ValidationResult;
import lombok.AllArgsConstructor;
import org.hl7.fhir.common.hapi.validation.support.*;
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValidationService {

    public void validateResource(FhirContext fhirContext, String resourceR4, String packageVerison) throws Exception {
        IParser parser = fhirContext.newJsonParser().setPrettyPrint(true);
        IBaseResource resource = parser.parseResource(resourceR4);
        String serialized = parser.encodeResourceToString(resource);
        System.out.println(serialized);

        ValidationSupportChain validationSupportChain = createNpmValidationSupportChain(fhirContext, packageVerison);
        CachingValidationSupport validationSupport = new CachingValidationSupport(validationSupportChain);

        ca.uhn.fhir.validation.FhirValidator validator = fhirContext.newValidator();
        FhirInstanceValidator instanceValidator = new FhirInstanceValidator(validationSupport);
        validator.registerValidatorModule(instanceValidator);
        ValidationResult result = validator.validateWithResult(serialized);
        System.out.println(result.isSuccessful());

        for (SingleValidationMessage next : result.getMessages()) {
            System.out.println(" Next issue " + next.getSeverity() + " - " + next.getLocationString() + " - " + next.getMessage());
        }
    }

    // TODO There is no cow level...
    public ValidationSupportChain createNpmValidationSupportChain(FhirContext fhirContext, String packageVersion) throws Exception {

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
