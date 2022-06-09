package com.jhkang.fhir.service.validation;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.validation.SingleValidationMessage;
import ca.uhn.fhir.validation.ValidationResult;
import com.jhkang.fhir.common.NpmSupporter;
import lombok.AllArgsConstructor;
import org.hl7.fhir.common.hapi.validation.support.CachingValidationSupport;
import org.hl7.fhir.common.hapi.validation.support.ValidationSupportChain;
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValidationService {

    public void validateResource(String resourceR4) throws Exception {

        // TODO 공통화 필요
        FhirContext fhirContext = FhirContext.forR4();
        IParser parser = fhirContext.newJsonParser().setPrettyPrint(true);
        IBaseResource resource = parser.parseResource(resourceR4);

        String serialized = parser.encodeResourceToString(resource);
        System.out.println(serialized);

        // TODO Service 개념으로 가져올 것
        NpmSupporter npmSupporter = new NpmSupporter();
        ValidationSupportChain validationSupportChain = npmSupporter.createNpmValidationSupportChain(fhirContext);
        CachingValidationSupport validationSupport = new CachingValidationSupport(validationSupportChain);

        // TODO 공통화 필요
        ca.uhn.fhir.validation.FhirValidator validator = fhirContext.newValidator();
        FhirInstanceValidator instanceValidator = new FhirInstanceValidator(validationSupport);
        validator.registerValidatorModule(instanceValidator);

        // TODO 공통화 필요
        ValidationResult result = validator.validateWithResult(serialized);
        System.out.println(result.isSuccessful());

        for (SingleValidationMessage next : result.getMessages()) {
            System.out.println(" Next issue " + next.getSeverity() + " - " + next.getLocationString() + " - " + next.getMessage());
        }
    }
}
