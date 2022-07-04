package com.espinas.fhir.domain.validation.repository;

import com.espinas.fhir.domain.validation.collection.Validation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface ValidationRepository extends MongoRepository<Validation, String> {
}
