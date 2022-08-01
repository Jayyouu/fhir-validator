package com.espinas.fhir.service.board;

import com.espinas.fhir.domain.board.collection.Board;
import com.espinas.fhir.domain.board.repository.BoardRepository;
import com.espinas.fhir.rest.dto.request.board.BoardRequest;
import com.espinas.fhir.rest.dto.response.board.BoardResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardResponse getBoard(String boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new RuntimeException());
        return BoardResponse.from(board);
    }

    public List<BoardResponse> getBoardList() {
        List<Board> boardList = boardRepository.findAll();
        return BoardResponse.fromList(boardList);
    }

    public BoardResponse addBoard(BoardRequest boardRequest) {
        Board board = BoardRequest.to(boardRequest);
        return BoardResponse.from(boardRepository.save(board));
    }

    public BoardResponse updateBoard(BoardRequest boardRequest) {
        Board board = boardRepository.findById(boardRequest.getId()).orElseThrow(
                () -> new RuntimeException());
        board.update(boardRequest);
        return BoardResponse.from(boardRepository.save(board));
    }

    public String deleteBoard(String boardId) {
        boardRepository.deleteById(boardId);
        return "Delete Success";
    }
}
