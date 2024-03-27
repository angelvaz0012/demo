package com.Joseangel.crud.demo.service;

import com.Joseangel.crud.demo.model.Persona;
import com.Joseangel.crud.demo.repositorio.PersonaRepositorio;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepositorio personaRepositorio;


    public Persona guardarPersona(Persona persona){

        if (persona.getId() == null) {
            return personaRepositorio.save(persona);
        }
        return null;
    }

    public Page<Persona> getAllPersona(Integer page, Integer size, Boolean enablePagination){
        return personaRepositorio.findAll(enablePagination ? PageRequest.of(page, size): Pageable.unpaged());


    }


    public Optional<Persona> findById(Long id){
        return personaRepositorio.findById(id);
    }

    public void BorrarPersona(Long id){
        personaRepositorio.deleteById(id);
    }

    public Persona editPersona (Persona persona){
        if (persona.getId() != null &&personaRepositorio.existsById(persona.getId())) {
            return personaRepositorio.save(persona);
        }
        return null;
    }

    public boolean existById(Long id) {
        return personaRepositorio.existsById(id);
    }
}
