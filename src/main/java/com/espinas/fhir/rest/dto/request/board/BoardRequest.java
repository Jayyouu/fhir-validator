package com.espinas.fhir.rest.dto.request.board;

import com.espinas.fhir.rest.dto.response.board.BoardResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardRequest {
    private int boardId;
    private String title;
    private String contents;
    private String writer;

    @Builder
    public BoardRequest(int boardId, String title, String contents, String writer) {
        this.boardId = boardId;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }

}
