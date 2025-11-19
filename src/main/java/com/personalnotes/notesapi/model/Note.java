package com.personalnotes.notesapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data // De Lombok: genera getters, setters, toString, equals y hashCode
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    private String content;

    // Opcional: Para registrar el momento de creacion
    private LocalDateTime createdAt = LocalDateTime.now(); 
}