package com.espinas.fhir.rest.dto.request.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class BoardRequest {
    @NotNull
    private Long boardId;
    @NotBlank
    private String title;
    @NotEmpty
    private String contents;
    @NotBlank
    private String writer;

    @Builder
    public BoardRequest(Long boardId, String title, String contents, String writer) {
        this.boardId = boardId;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }
}
