package com.espinas.fhir.rest.dto.response.board;

import com.espinas.fhir.domain.board.collection.Board;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardResponse {
    
    private String id;
    
    private String title;
    
    private String contents;
    
    private String writer;

    private LocalDateTime createDate;

    private LocalDateTime modifiedDate;

    @Builder
    public BoardResponse(String id, String title, String contents, String writer, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public static BoardResponse from(Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .contents(board.getContents())
                .writer(board.getWriter())
                .createDate(board.getCreatedDate())
                .modifiedDate(board.getLastModifiedDate())
                .build();
    }

    public static List<BoardResponse> fromList(List<Board> boardList) {
        List<BoardResponse> boardResponseList = new ArrayList<>();
        boardList.forEach(board -> boardResponseList.add(
                BoardResponse.from(board)
        ));
        return boardResponseList;
    }
}




