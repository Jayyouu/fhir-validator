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
    @DisplayName("Given : boardResponse 객체에 값(데이터)이 주어졌을 때 " +
            "When : getMapping된 board url을 호출하고 " +
            "Then : title 값이 제대로 출력 되면 정상 출력될 것을 예상")
    void getBoardTest() throws Exception {
        BoardResponse boardResponse = BoardResponse.builder()
                .boardId("1")
                .title("title")
                .contents("geer")
                .writer("jj")
                .build();

        mockMvc.perform(get("/board"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("title").value(boardResponse.getTitle()));
    }

    BoardRequest boardRequest = BoardRequest.builder()
            .boardId("2")
            .title("aaa")
            .contents("bbb")
            .writer("ccc")
            .build();

    @Test
    @DisplayName("Given : boardRequest 객체에 값(데이터) 주어졌을 때 " +
            "When : postMapping된 board url 호출하고, 데이터를 json 형식으로 보내면 " +
            "Then : 입력한 값들이 정상 출력될 것을 예상")
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
    @DisplayName("Given : boardRequest 객체에 값(데이터)이 주어졌을 때 " +
            "When : putMapping된 board url 호출하고, 데이터를 json 형식으로 보내면 " +
            "Then : 입혁한 값들이 정상 출력될 것을 예상")
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