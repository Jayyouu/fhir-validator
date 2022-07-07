package com.espinas.fhir.domain.board.collection;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "board")
@NoArgsConstructor
public class Board {
    @Id
    private String boardId;
    private String title;
    private String contents;
    private String writer;

    @Builder
    public Board(String boardId, String title, String contents, String writer) {
        this.boardId = boardId;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }
}
