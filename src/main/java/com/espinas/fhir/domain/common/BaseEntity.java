package com.espinas.fhir.domain.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document
public class BaseEntity {

    @Transient
    public static final String SEQUENCE_NAME = "base_sequence";

    @Id
    private String id;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime LastModifiedDate;

    @Version
    private Long version;

    public void setId(String id) {
        this.id = id;
    }
}
