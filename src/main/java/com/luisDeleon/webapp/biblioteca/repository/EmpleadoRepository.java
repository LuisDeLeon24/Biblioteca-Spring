package com.luisDeleon.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisDeleon.webapp.biblioteca.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
