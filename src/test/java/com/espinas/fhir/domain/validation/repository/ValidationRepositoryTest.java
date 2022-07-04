package com.espinas.fhir.domain.validation.repository;

import com.espinas.fhir.domain.validation.collection.Validation;
import com.espinas.fhir.support.RepositoryTestSupport;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationRepositoryTest extends RepositoryTestSupport {

    @Autowired
    private ValidationRepository validationRepository;

    @BeforeAll
    public void setUp() {
        Validation validation = Validation.builder().data("{\"test title\":\"test contents\"}").build();
        validationRepository.save(validation);
    }

    @AfterEach
    void cleanUpDatabase()
    {
        this.validationRepository.deleteAll();
    }


    @Test
    @DisplayName("getValidation Test")
    public void getValidationTest() {
        List<Validation> validationList = validationRepository.findAll();
        System.out.println("testzzzzzzzzzzzz" + validationList.get(0).getData());
        System.out.println("testzzzzzzzzzzzz" + validationList.get(0).getId());
        System.out.println("testzzzzzzzzzzzz" + validationList.get(0).getCreatedDate());
        System.out.println("testzzzzzzzzzzzz" + validationList.get(0).getLastModifiedDate());

        Assertions.assertAll(
                () -> assertEquals(validationList.size(), 1)
        );
    }
}