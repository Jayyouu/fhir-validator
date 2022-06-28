package com.espinas.fhir.domain.validation.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "validation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Validation {

    @Id
    private Long id;

    private String contents;

    @Builder
    public Validation(Long id, String contents) {
        this.id = id;
        this.contents = contents;
    }

}
