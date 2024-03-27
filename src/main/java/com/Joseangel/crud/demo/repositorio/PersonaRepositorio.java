package com.Joseangel.crud.demo.repositorio;

import com.Joseangel.crud.demo.model.Persona;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Long> {
}
