package com.espinas.fhir.rest.controller.api.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(BoardController.class)
@AutoConfigureMockMvc
public class BoardControllerTest {

    @Test
    @DisplayName("GetMapping Test")
    void getBoardTest() {

    }
}