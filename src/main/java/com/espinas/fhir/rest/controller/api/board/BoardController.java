package com.espinas.fhir.rest.controller.api.board;

import com.espinas.fhir.rest.dto.request.board.BoardRequest;
import com.espinas.fhir.rest.dto.response.board.BoardResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/board")
public class BoardController {
    @GetMapping("/get")
    public BoardResponse boardResponse() {
        return BoardResponse.builder()
                .boardId(1L)
                .title("title")
                .contents("geer")
                .writer("jj")
                .build();
    }

    @PostMapping("/post")
    public BoardRequest boardRequest(@Valid @RequestBody BoardRequest boardRequest) {
        return boardRequest;
    }

    @PutMapping("/put")
    public BoardRequest brq(@Valid @RequestBody BoardRequest brq) {
        return brq;
    }

    @DeleteMapping("/delete")
    public BoardRequest boardRequest() {
        return BoardRequest.builder()
                .boardId(2L)
                .title("2222")
                .contents("aaa")
                .writer("ee")
                .build();
    }
}
