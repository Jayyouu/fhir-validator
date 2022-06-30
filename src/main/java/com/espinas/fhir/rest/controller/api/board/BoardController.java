package com.espinas.fhir.rest.controller.api.board;

import com.espinas.fhir.rest.dto.request.board.BoardRequest;
import com.espinas.fhir.rest.dto.response.board.BoardResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BoardController {
    @GetMapping("/board")
    public BoardResponse roadboard() {
        return BoardResponse.builder()
                .boardId(1L)
                .title("title")
                .contents("geer")
                .writer("jj")
                .build();
    }

    @PostMapping("/board")
    public BoardRequest createboard(@Valid @RequestBody BoardRequest boardRequest) {
        return boardRequest;
    }

    @PutMapping("/board")
    public BoardRequest putboard(@Valid @RequestBody BoardRequest boardRequest) {
        return boardRequest;
    }

    @DeleteMapping("/board/{boardId}")
    public BoardRequest deleteboard(@PathVariable Long boardId) {
        return BoardRequest.builder()
                .boardId(boardId)
                .build();
    }
}
