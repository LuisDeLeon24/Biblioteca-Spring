package com.luisDeleon.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisDeleon.webapp.biblioteca.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
