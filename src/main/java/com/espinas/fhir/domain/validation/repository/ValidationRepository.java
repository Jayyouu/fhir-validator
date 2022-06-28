package com.espinas.fhir.domain.validation.repository;

import com.espinas.fhir.domain.validation.entity.Validation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ValidationRepository extends MongoRepository<Validation, Long> {
}
