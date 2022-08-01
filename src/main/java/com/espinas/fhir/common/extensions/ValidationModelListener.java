package com.espinas.fhir.common.extensions;

import com.espinas.fhir.domain.common.BaseEntity;
import com.espinas.fhir.service.common.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class ValidationModelListener extends AbstractMongoEventListener<BaseEntity> {

    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<BaseEntity> event) {
        event.getSource().setId(sequenceGeneratorService.generateSequence(BaseEntity.SEQUENCE_NAME).toString());
    }
}
