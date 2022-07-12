package com.espinas.fhir.rest.controller.api.board;

import com.espinas.fhir.domain.board.collection.Board;
import com.espinas.fhir.rest.dto.request.board.BoardRequest;
import com.espinas.fhir.rest.dto.response.board.BoardResponse;
import com.espinas.fhir.service.board.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public List<BoardResponse> getBoardAll() {
        List<Board> boardList = boardService.getBoardAll();
        List<BoardResponse> boardResponsesList = new ArrayList<>();
        for (Board board : boardList) {
        BoardResponse boardResponse = BoardResponse.from(board);
           boardResponsesList.add(boardResponse);
       }
        return boardResponsesList;
    }

    @PostMapping
    public BoardResponse addBoard(@Valid @RequestBody BoardRequest boardRequest) {
        Board board = boardService.addBoard(boardRequest);
        BoardResponse boardResponse = BoardResponse.from(board);
        return boardResponse;
    }

    @PutMapping
    public BoardResponse updateBoard(@Valid @RequestBody BoardRequest boardRequest) {
        Board board = boardService.updateBoard(boardRequest);
        BoardResponse boardResponse = BoardResponse.from(board);
        return boardResponse;
    }

    @DeleteMapping("/{boardId}")
    public String deleteBoard(@PathVariable String boardId) {
        boardService.deleteBoard(boardId);
        String message = "Delete Success";
        return message;
    }
}
