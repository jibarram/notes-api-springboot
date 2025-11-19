package com.personalnotes.notesapi.repository;

import com.personalnotes.notesapi.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Al extender JpaRepository, Spring genera automaticamente los metodos CRUD
@Repository 
public interface NoteRepository extends JpaRepository<Note, Long> {
    // Podemos anadir metodos de busqueda personalizados aqui si son necesarios
}