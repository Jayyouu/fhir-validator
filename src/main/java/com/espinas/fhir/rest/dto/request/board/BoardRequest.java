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
    @NotEmpty
    private String title;
    @NotNull
    @NotEmpty
    private String contents;
    @NotNull
    private String writer;

    @Builder
    public BoardRequest(Long boardId, String title, String contents, String writer) {
        this.boardId = boardId;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }
}
