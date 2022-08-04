package com.espinas.fhir.common.extensions;

import com.espinas.fhir.domain.common.BaseDocument;
import com.espinas.fhir.service.common.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BaseDocumentModelListener extends AbstractMongoEventListener<BaseDocument> {

    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<BaseDocument> event) {
        event.getSource().setId(sequenceGeneratorService.generateSequence(BaseDocument.SEQUENCE_NAME).toString());
    }
}
