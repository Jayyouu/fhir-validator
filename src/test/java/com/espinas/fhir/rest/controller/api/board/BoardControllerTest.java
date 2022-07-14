package com.espinas.fhir.rest.controller.api.board;

import com.espinas.fhir.domain.board.collection.Board;
import com.espinas.fhir.rest.dto.request.board.BoardRequest;
import com.espinas.fhir.service.board.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BoardController.class)
public class BoardControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private BoardService boardService;

    private BoardRequest createOneUpdateBoardRequest() {
        return BoardRequest.builder()
                .boardId("4")
                .title("ddd")
                .contents("ddddd")
                .writer("ddddd")
                .build();
    }

    private Board createOneUpdateBoard() {
        return Board.builder()
                .boardId("1")
                .title("aaa")
                .contents("aaaa")
                .writer("aaaa")
                .build();
    }

    private Board createOneBoard() {
        return Board.builder()
                .boardId("1")
                .title("aaaa")
                .contents("aaaa")
                .writer("aaaa")
                .build();
    }

    private List<Board> creatSeveralBoard() {
        Board board1 = Board.builder()
                .boardId("1")
                .title("aaa")
                .contents("aaaa")
                .writer("aaaa")
                .build();

        Board board2 = Board.builder()
                .boardId("2")
                .title("bbb")
                .contents("bbbb")
                .writer("bbbb")
                .build();

        Board board3 = Board.builder()
                .boardId("3")
                .title("ccc")
                .contents("cccc")
                .writer("cccc")
                .build();

        return asList(board1, board2, board3);
    }

    @Test
    @DisplayName("Given : board 객체에 값(데이터)이 주어졌을 때 " +
            "When : getMapping된 board url을 호출하고 " +
            "Then : boardId가 1인 board 객체가 출력될 것을 예상")
    void getBoardTest() throws Exception {
        Board board = createOneBoard();

//        when(boardService.getBoard(any())).thenReturn(board);

//        mockMvc.perform(get("/board/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("boardId").value(board.getBoardId()))
//                .andExpect(jsonPath("title").value(board.getTitle()))
//                .andExpect(jsonPath("contents").value(board.getContents()))
//                .andExpect(jsonPath("writer").value(board.getWriter()));
    }

//    @Test
//    @DisplayName("Given : boardList에 값(데이터)들이 주어졌을 때" +
//            "When : " +
//            "Then : ")
//    void getBoardListTest() throws Exception {
//        List<Board> boardList = creatSeveralBoard();
//
//        when(boardService.getBoardList()).thenReturn(boardList);
//
//        mockMvc.perform(get("board"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.*", hasSize(5)));
//
////        when(boardService.getBoardList(any())).thenReturn(boardList);
//
///*        mockMvc.perform(get("/board"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath())*/
//    }
//
//    @Test
//    @DisplayName("Given : boardRequest 객체에 값(데이터) 주어졌을 때 " +
//            "When : postMapping된 board url 호출하고, 데이터를 json 형식으로 보내면 " +
//            "Then : 입력한 값들이 정상 출력될 것을 예상")
//    void addBoardTest() throws Exception {
//        Board board = createOneBoard();
//
//        when(boardService.addBoard(any())).thenReturn(board);
//
//        ResultActions resultActions =
//                mockMvc.perform(post("/board")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(board))
//                );
//        resultActions.andExpect(status().isOk())
//                .andExpect(jsonPath("boardId").value(board.getBoardId()))
//                .andExpect(jsonPath("title").value(board.getTitle()))
//                .andExpect(jsonPath("contents").value(board.getContents()))
//                .andExpect(jsonPath("writer").value(board.getWriter()));
//    }
//
//    @Test
//    @DisplayName("Given : boardRequest 객체에 값(데이터)이 주어졌을 때 " +
//            "When : putMapping된 board url 호출하고, 데이터를 json 형식으로 보내면 " +
//            "Then : board 객체에서 입력된 값(데이터)을 정상 출력될 것을 예상")
//    void updateBoardTest() throws Exception {
//        BoardRequest boardRequest = createOneUpdateBoardRequest();
//        Board board = createOneUpdateBoard();
//
//        when(boardService.updateBoard(any())).thenReturn(board);
//
//        ResultActions resultActions =
//                mockMvc.perform(put("/board")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(boardRequest))
//                );
//        resultActions.andExpect(status().isOk())
//                .andExpect(jsonPath("boardId").value(boardRequest.getBoardId()))
//                .andExpect(jsonPath("title").value(boardRequest.getTitle()))
//                .andExpect(jsonPath("contents").value(boardRequest.getContents()))
//                .andExpect(jsonPath("writer").value(boardRequest.getWriter()));
//    }
}
