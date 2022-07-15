package com.espinas.fhir.rest.dto.response.board;

import com.espinas.fhir.domain.board.collection.Board;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BoardResponse {
    private String boardId;
    private String title;
    private String contents;
    private String writer;

    @Builder
    public BoardResponse(String boardId, String title, String contents, String writer) {
        this.boardId = boardId;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }

    public static BoardResponse from(Board board) {
        return BoardResponse.builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .contents(board.getContents())
                .writer(board.getWriter())
                .build();
    }

    public static List<BoardResponse> fromList(List<Board> boardList) {
        List<BoardResponse> boardResponseList = new ArrayList<>();

        boardList.forEach(board -> boardResponseList.add(
                BoardResponse.builder()
                        .boardId(board.getBoardId())
                        .title(board.getTitle())
                        .contents(board.getContents())
                        .writer(board.getWriter())
                        .build()
        ));
        return boardResponseList;
    }
}




