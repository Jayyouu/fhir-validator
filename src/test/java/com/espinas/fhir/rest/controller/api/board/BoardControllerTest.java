package com.espinas.fhir.rest.controller.api.board;

import com.espinas.fhir.rest.dto.request.board.BoardRequest;
import com.espinas.fhir.rest.dto.response.board.BoardResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BoardController.class)
@AutoConfigureMockMvc
public class BoardControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void returnHelloOk() throws Exception {
        String hello = "Hello";

        mockMvc.perform(MockMvcRequestBuilders.get("/board/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    @DisplayName("getMappingTest")
    void getBoardTest() throws Exception {
        BoardResponse boardResponse = BoardResponse.builder()
                .boardId(1L)
                .title("title")
                .contents("geer")
                .writer("jj")
                .build();


        mockMvc.perform(MockMvcRequestBuilders.get("/board"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("title").value(boardResponse.getTitle()));
    }

    @Test
    @DisplayName("postMappingTest")
    void addBoardTest() throws Exception {
        BoardRequest boardRequest = BoardRequest.builder()
                .boardId(2L)
                .title("aaa")
                .contents("bbb")
                .writer("ccc")
                .build();

        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/board")
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
        BoardRequest boardRequest = BoardRequest.builder()
                .boardId(3L)
                .title("aaaa")
                .contents("bbbb")
                .writer("cccc")
                .build();

        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.put("/board")
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