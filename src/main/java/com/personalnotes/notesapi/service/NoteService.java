package com.personalnotes.notesapi.service;

import com.personalnotes.notesapi.model.Note;
import java.util.List;
import java.util.Optional;

public interface NoteService {
    
    // READ
    List<Note> findAllNotes();
    Optional<Note> findNoteById(Long id);

    // CREATE / UPDATE
    Note saveNote(Note note);

    // DELETE
    void deleteNote(Long id);
}