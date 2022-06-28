package com.espinas.fhir.rest.controller.api.board;

import com.espinas.fhir.rest.dto.response.board.BoardResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    @GetMapping("/boardResponse")
    public BoardResponse boardResponse() {
        return BoardResponse.builder()
                .boardId(1L)
                .title("title")
                .contents("geer")
                .writer("jj")
                .build();
    }
}
