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
    // FIXME
    @Disabled
    public void setUp() {

        // FIXME java Long type -> String type
        validationRepository.save(Validation.builder().data("{\"test title\":\"test contents\"}").build());
        validationRepository.save(Validation.builder().data("{\"test title2\":\"test contents2\"}").build());
    }

    @Test
    // FIXME
    @Disabled
    @DisplayName("getValidation Test")
    public void getValidationTest() {
        List<Validation> validationList = validationRepository.findAll();
        System.out.println("testzzzzzzzzzzzz" + validationList.get(0).getData());
        System.out.println("testzzzzzzzzzzzz" + validationList.get(0).get_id());
        System.out.println("testzzzzzzzzzzzz" + validationList.get(0).getCreatedDate());
        System.out.println("testzzzzzzzzzzzz" + validationList.get(0).getLastModifiedDate());
        System.out.println("testzzzzzzzzzzzz" + validationList.get(1).get_id());
        System.out.println("testzzzzzzzzzzzz" + validationList.get(1).getData());

        Assertions.assertAll(
                () -> assertEquals(validationList.size(), 2)
        );
    }
}