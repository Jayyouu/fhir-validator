package com.espinas.fhir.rest.dto.request.board;

import com.espinas.fhir.domain.board.collection.Board;
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
    private String boardId;
    @NotBlank
    private String title;
    @NotEmpty
    private String contents;
    @NotBlank
    private String writer;

    @Builder
    public BoardRequest(String boardId, String title, String contents, String writer) {
        this.boardId = boardId;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }

    public static Board form(BoardRequest boardRequest) {
        return Board.builder()
                .boardId(boardRequest.getBoardId())
                .title(boardRequest.getTitle())
                .contents(boardRequest.getContents())
                .writer(boardRequest.getWriter())
                .build();
    }
}
