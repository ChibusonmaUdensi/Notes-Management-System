package com.example.notesmanagementsystem.data.repository;

import com.example.notesmanagementsystem.data.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends MongoRepository<Note, String> {
}
