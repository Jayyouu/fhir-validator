package com.espinas.fhir.rest.dto.response.board;


import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponse {
    private Long boardId;
    private String title;
    private String contents;
    private String writer;

    @Builder
    public BoardResponse(Long boardId, String title, String contents, String writer) {
        this.boardId = boardId;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }
}




