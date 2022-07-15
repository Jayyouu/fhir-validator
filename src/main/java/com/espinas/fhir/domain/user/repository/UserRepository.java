package com.espinas.fhir.domain.user.repository;

import com.espinas.fhir.domain.user.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
