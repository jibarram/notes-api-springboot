package com.personalnotes.notesapi.controller;

import com.personalnotes.notesapi.exception.ResourceNotFoundException;
import com.personalnotes.notesapi.model.Note;
import com.personalnotes.notesapi.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/notes") 
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // 1. GET ALL NOTES (READ)
    // GET http://localhost:8080/api/notes
    @GetMapping
    @Operation(summary = "Obtener todas las notas", description = "Recupera una lista de todas las notas almacenadas.")
    public List<Note> getAllNotes() {
        return noteService.findAllNotes();
    }

    // 2. GET NOTE BY ID (READ)
    // GET http://localhost:8080/api/notes/{id}
    @GetMapping("/{id}")
    @Operation(summary = "Obtener nota mediante ID", description = "Recupera una nota almacenada.")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return noteService.findNoteById(id)
            .map(note -> ResponseEntity.ok(note))
            .orElseThrow(() -> new ResourceNotFoundException("Note not found with id: " + id));
    }

    // 3. CREATE NEW NOTE (CREATE)
    // POST http://localhost:8080/api/notes
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crea una nota", description = "Crea una nueva nota con los datos ingresados.")
    public Note createNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }

    // 4. UPDATE EXISTING NOTE (UPDATE)
    // PUT http://localhost:8080/api/notes/{id}
    @PutMapping("/{id}")
    @Operation(summary = "Actualiza una nota", description = "Actualiza los datos de una nota ingresada.")
    public Note updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        Note existingNote = noteService.findNoteById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Note not found with id: " + id));
    
        existingNote.setTitle(noteDetails.getTitle());
        existingNote.setContent(noteDetails.getContent());
        
        return noteService.saveNote(existingNote);
    }

    // 5. DELETE NOTE (DELETE)
    // DELETE http://localhost:8080/api/notes/{id}
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar nota", description = "Elimina una nota almacenada.")
    public ResponseEntity<?> deleteNote(@PathVariable Long id) {
        noteService.findNoteById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Note not found with id: " + id));
        
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
}