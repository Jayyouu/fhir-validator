package com.espinas.fhir.service.validation;

import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.validation.FhirValidator;
import ca.uhn.fhir.validation.SingleValidationMessage;
import ca.uhn.fhir.validation.ValidationResult;
import com.espinas.fhir.domain.validation.repository.ValidationRepository;
import com.espinas.fhir.rest.dto.response.validation.ValidationResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.espinas.fhir.FhirConfig.getFhirValidator;
import static com.espinas.fhir.FhirConfig.getIParser;

@AllArgsConstructor
@Service
@Slf4j
public class ValidationService {

    private final ValidationRepository validationRepository;

    public List<ValidationResponse> validateResource(String resourceR4, String packageVersion) throws Exception {
        FhirValidator fhirValidator = getFhirValidator(packageVersion);

        // TODO
        IParser parser = getIParser();
        IBaseResource resource = parser.parseResource(resourceR4);

        String serialized = parser.encodeResourceToString(resource);
        ValidationResult result = fhirValidator.validateWithResult(serialized);

        // log
        for (SingleValidationMessage next : result.getMessages()) {
            log.info(" Next issue " + next.getSeverity() + " - " + next.getLocationString() + " - " + next.getMessage());
        }

        // FIXME
        List<ValidationResponse> validationResponseList = ValidationResponse.fromList(result.getMessages());
        validationResponseList.forEach(validationResponse -> validationRepository.save(ValidationResponse.to(validationResponse)));

        return validationResponseList;
    }
}
