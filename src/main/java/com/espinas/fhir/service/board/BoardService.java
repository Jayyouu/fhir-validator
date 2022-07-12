package com.espinas.fhir.service.board;

import com.espinas.fhir.domain.board.collection.Board;
import com.espinas.fhir.domain.board.repository.BoardRepository;
import com.espinas.fhir.rest.dto.request.board.BoardRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getBoardAll() {
        return boardRepository.findAll();
    }

    public Board getBoardOne(BoardRequest boardRequest) {
        Board board = boardRepository.findById(boardRequest.getBoardId()).orElseThrow(
                () -> new RuntimeException()
        );
        return board;
    }

    public Board addBoard(BoardRequest boardRequest) {
        Board board = BoardRequest.from(boardRequest);
        return boardRepository.save(board);
    }

    public Board updateBoard(BoardRequest boardRequest) {
        Board board = getBoardOne(boardRequest);
        // boardRepository.findById(boardRequest.getBoardId()).orElseThrow(
        // () -> new RuntimeException());
        board.update(boardRequest);
        boardRepository.save(board);
        return board;
    }

    public void deleteBoard(String boardId) {
        boardRepository.deleteById(boardId);
    }
}
