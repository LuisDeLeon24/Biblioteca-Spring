package com.luisDeleon.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisDeleon.webapp.biblioteca.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
