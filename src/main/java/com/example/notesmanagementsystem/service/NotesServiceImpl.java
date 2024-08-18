package com.example.notesmanagementsystem.service;

import com.example.notesmanagementsystem.data.dto.RequestNoteDto;
import com.example.notesmanagementsystem.data.dto.RequestUserDto;
import com.example.notesmanagementsystem.data.model.Note;
import com.example.notesmanagementsystem.data.model.User;
import com.example.notesmanagementsystem.data.repository.NotesRepository;
import com.example.notesmanagementsystem.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService{


    @Autowired
    private NotesRepository notesRepository;

        @Autowired
        private UserRepository userRepository;

    @Override
    public Note createNote(RequestNoteDto requestNoteDto) {

        Optional<User> optionalUser = userRepository.findByEmail(requestNoteDto.getUser().getEmail());
        if (optionalUser.isPresent()) {

            Note newNote = new Note();
            newNote.setUser(requestNoteDto.getUser());
            newNote.setId(requestNoteDto.getId());
            newNote.setTitle(requestNoteDto.getTitle());
            newNote.setCreatedAt(LocalDateTime.now());
            notesRepository.save(newNote);
            return newNote;
        }
else {
            throw new NullPointerException("create an account dearie");
        }
    }

    @Override
    public String deleteNote(String id) {
        Optional<Note> noteToDelete = notesRepository.findById(id);
        if (noteToDelete.isPresent()) {
            notesRepository.delete(noteToDelete.get());
            return "Note deleted";
        } else {
            return "Note doesn't exist, mfjpm.";

        }
    }
    @Override
    public Note editNote(RequestNoteDto requestNoteDto) {
       Optional <Note> noteToEdit = notesRepository.findById(requestNoteDto.getId());
       if (noteToEdit.isPresent()){
           Note updateNote = noteToEdit.get();
           updateNote.setTitle(requestNoteDto.getTitle());
           updateNote.setContent(requestNoteDto.getContent());
           updateNote.setCreatedAt(LocalDateTime.now());
           return updateNote;

       } else{
           throw new NullPointerException("Note not found, fishpieeeeeeeeeeeee");
       }
    }

    @Override
    public Note findNoteById(String id) {
        Optional <Note> findNote = notesRepository.findById(id);
        if (findNote.isPresent()){
           return findNote.get();
        }
        throw new NullPointerException("Note doesn't exist");
    }

    @Override
    public List<Note> findAllNotes() {
        return notesRepository.findAll();
    }
}


