package com.espinas.fhir.domain.board.repository;

import com.espinas.fhir.domain.board.collection.Board;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoardRepository extends MongoRepository<Board, String> {
}
