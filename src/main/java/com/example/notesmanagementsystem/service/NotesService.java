package com.example.notesmanagementsystem.service;

import com.example.notesmanagementsystem.data.dto.RequestNoteDto;
import com.example.notesmanagementsystem.data.model.Note;

import java.util.List;

public interface NotesService {
    Note createNote(RequestNoteDto requestNoteDto);
    String deleteNote(String id);
    Note editNote(RequestNoteDto requestNoteDto);
    Note findNoteById(String id);
    List<Note> findAllNotes();
}
