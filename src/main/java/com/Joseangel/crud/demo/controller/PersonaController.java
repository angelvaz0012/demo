package com.Joseangel.crud.demo.controller;

import com.Joseangel.crud.demo.model.Persona;
import com.Joseangel.crud.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ResponseEntity<Persona> guardarPersona(@RequestBody Persona persona){
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.guardarPersona(persona));

    }
    @GetMapping
     public ResponseEntity<Page<Persona>> getAllPersona(
             @RequestParam(required = false,defaultValue = "0") Integer page,
             @RequestParam(required = false,defaultValue = "10")Integer size,
             @RequestParam(required = false,defaultValue = "false")Boolean enablePagination
    ) {
        return ResponseEntity.ok(personaService.getAllPersona(page, size, enablePagination));


     }
     @DeleteMapping(value = "/{id}")
    public void BorrarPersona(@PathVariable ("id") Long id) {
         personaService.BorrarPersona(id);
         ResponseEntity.ok(!personaService.existById(id));

     }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Persona>> findPersonaById(@PathVariable ("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(personaService.findById(id));


    }
    @PutMapping
    public ResponseEntity<Persona> editPersona (@RequestBody Persona persona){
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.editPersona(persona));

    }


}
