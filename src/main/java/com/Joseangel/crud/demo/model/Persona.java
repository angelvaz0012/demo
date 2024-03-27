package com.Joseangel.crud.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String nombrePaterno;
    private Long telefono;

}

