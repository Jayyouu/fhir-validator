package com.espinas.fhir.rest.controller.api.board;

import com.espinas.fhir.rest.dto.request.board.BoardRequest;
import com.espinas.fhir.rest.dto.response.board.BoardResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/board")
public class BoardController {
    @GetMapping
    public BoardResponse loadBoard() {
        return BoardResponse.builder()
                .boardId(1L)
                .title("title")
                .contents("geer")
                .writer("jj")
                .build();
    }

    @PostMapping
    public BoardRequest createBoard(@Valid @RequestBody BoardRequest boardRequest) {
        return boardRequest;
    }

    @PutMapping
    public BoardRequest putBoard(@Valid @RequestBody BoardRequest boardRequest) {
        return boardRequest;
    }

    @DeleteMapping("/{boardId}")
    public BoardRequest deleteBoard(@PathVariable Long boardId) {
        return BoardRequest.builder()
                .boardId(boardId)
                .build();
    }
}
