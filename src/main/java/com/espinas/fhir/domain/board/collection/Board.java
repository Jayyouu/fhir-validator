package com.espinas.fhir.domain.board.collection;

import com.espinas.fhir.rest.dto.request.board.BoardRequest;
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

    public void update(BoardRequest boardRequest) {
        this.boardId = boardRequest.getBoardId();
        this.title = boardRequest.getTitle();
        this.contents = boardRequest.getContents();
        this.writer = boardRequest.getWriter();
    }
}
