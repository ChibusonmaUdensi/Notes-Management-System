package com.example.notesmanagementsystem.web;


import com.example.notesmanagementsystem.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.example.notesmanagementsystem.data.model.Note;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NotesController {

        @Autowired
        private NotesService notesService;


        @GetMapping("/getAllNotes")
        public ResponseEntity<List<Note>> getAll(){
            List<Note> notes = notesService.findAllNotes();
            return new ResponseEntity<>(notes, HttpStatus.OK);
        }

        @GetMapping
    public ResponseEntity <Note> findById(@PathVariable String id){
            Note note = notesService.findNoteById(id);
            if (note == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(note);
        }



}
