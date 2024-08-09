package com.luisDeleon.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisDeleon.webapp.biblioteca.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

}
