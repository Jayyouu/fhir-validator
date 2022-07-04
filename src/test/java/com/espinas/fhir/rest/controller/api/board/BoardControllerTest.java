package com.espinas.fhir.rest.controller.api.board;

import com.espinas.fhir.rest.dto.request.board.BoardRequest;
import com.espinas.fhir.rest.dto.response.board.BoardResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BoardController.class)
public class BoardControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("getMappingTest")
    void getBoardTest() throws Exception {
        BoardResponse boardResponse = BoardResponse.builder()
                .boardId(1L)
                .title("title")
                .contents("geer")
                .writer("jj")
                .build();

        mockMvc.perform(get("/board"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("title").value(boardResponse.getTitle()));
    }

    BoardRequest boardRequest = BoardRequest.builder()
            .boardId(2L)
            .title("aaa")
            .contents("bbb")
            .writer("ccc")
            .build();

    @Test
    @DisplayName("postMappingTest")
    void addBoardTest() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(post("/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(boardRequest))
                );
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("boardId").value(boardRequest.getBoardId()))
                .andExpect(jsonPath("title").value(boardRequest.getTitle()))
                .andExpect(jsonPath("contents").value(boardRequest.getContents()))
                .andExpect(jsonPath("writer").value(boardRequest.getWriter()));
    }

    @Test
    @DisplayName("putMappingTest")
    void updateBoardTest() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(put("/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(boardRequest))
                );
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("boardId").value(boardRequest.getBoardId()))
                .andExpect(jsonPath("title").value(boardRequest.getTitle()))
                .andExpect(jsonPath("contents").value(boardRequest.getContents()))
                .andExpect(jsonPath("writer").value(boardRequest.getWriter()));
    }
}