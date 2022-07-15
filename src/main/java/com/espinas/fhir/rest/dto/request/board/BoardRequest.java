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

    private String id;

    private String title;

    private String contents;

    private String writer;

    @Builder
    public BoardRequest(String id, String title, String contents, String writer) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }

    public static Board to(BoardRequest boardRequest) {
        return Board.builder()
                .title(boardRequest.getTitle())
                .contents(boardRequest.getContents())
                .writer(boardRequest.getWriter())
                .build();
    }
}
