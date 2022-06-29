package com.espinas.fhir.domain.common;

import com.espinas.fhir.domain.common.BaseEntity;
import com.espinas.fhir.domain.validation.collection.Validation;
import com.espinas.fhir.service.common.SequenceGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BaseEntityListener extends AbstractMongoEventListener<BaseEntity> {

    private final SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<BaseEntity> event) {
        event.getSource().setId(sequenceGeneratorService.generateSequence(BaseEntity.SEQUENCE_NAME));
    }

// FIXME
//    @Override
//    public void onBeforeSave(BeforeSaveEvent<BaseEntity> event) {
//        event.getSource().setId(sequenceGeneratorService.generateSequence(BaseEntity.SEQUENCE_NAME));
//    }
}