package com.espinas.fhir.domain.validation.repository;

import com.espinas.fhir.domain.validation.collection.Validation;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ValidationRepositoryTest {

    @Autowired
    private ValidationRepository validationRepository;

    @BeforeAll
    public void setUp() {
        validationRepository.save(Validation.builder().id(1L).contents("{\"test title\":\"test contents\"}").build());
    }

    @Test
    @DisplayName("getValidation Test")
    public void getValidationTest() {
        List<Validation> validationList = validationRepository.findAll();

        Assertions.assertAll(
                () -> assertEquals(validationList.size(), 1)
        );
    }
}