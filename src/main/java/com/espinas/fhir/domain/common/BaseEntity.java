package com.espinas.fhir.domain.common;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Document(collection = "baseEntity")
public class BaseEntity {

    @Transient
    public static final String SEQUENCE_NAME = "base_sequence";

    @Id
    private Long _id;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime LastModifiedDate;

    public void setId(Long _id) {
        this._id = _id;
    }
}
