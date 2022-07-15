package com.espinas.fhir.rest.controller.api.board;

import com.espinas.fhir.rest.controller.BaseController;
import com.espinas.fhir.rest.dto.request.board.BoardRequest;
import com.espinas.fhir.rest.dto.response.Response;
import com.espinas.fhir.service.board.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController extends BaseController {
    private final BoardService boardService;

    @GetMapping("/{boardId}")
    public ResponseEntity<Response> getBoard(@PathVariable String boardId) {
        return response(boardService.getBoard(boardId));
    }


    @GetMapping
    public ResponseEntity<Response> getBoardList() {
        return response(boardService.getBoardList());
    }


    @PostMapping
    public ResponseEntity<Response> addBoard(@Valid @RequestBody BoardRequest boardRequest) {
        return response(boardService.addBoard(boardRequest));
    }


    @PutMapping
    public ResponseEntity<Response> updateBoard(@Valid @RequestBody BoardRequest boardRequest) {
        return response(boardService.updateBoard(boardRequest));
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Response> deleteBoard(@PathVariable String boardId) {
        boardService.deleteBoard(boardId);
        return response("Delete Success");
    }
}
