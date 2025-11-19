package com.personalnotes.notesapi.service;

import com.personalnotes.notesapi.model.Note;
import com.personalnotes.notesapi.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service // Marca la clase como un componente de servicio de Spring
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    // Inyeccion de Dependencias (Constructor Injection - la mejor practica)
    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // CREATE / UPDATE
    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    // READ ALL
    @Override
    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    // READ BY ID
    @Override
    public Optional<Note> findNoteById(Long id) {
        return noteRepository.findById(id);
    }

    // DELETE
    @Override
    public void deleteNote(Long id) {
        // En un entorno real, aqui validarias si la nota existe antes de borrar
        noteRepository.deleteById(id);
    }
}