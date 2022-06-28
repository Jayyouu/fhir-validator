package com.espinas.fhir.domain.validation.component;

import com.espinas.fhir.domain.validation.collection.Validation;
import com.espinas.fhir.service.common.SequenceGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ValidationListener extends AbstractMongoEventListener<Validation> {

    private final SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Validation> event) {
        event.getSource().setId(sequenceGeneratorService.generateSequence(Validation.SEQUENCE_NAME));
    }
}