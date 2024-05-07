package com.pichincha.clientes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
public class Persona {

    @Id
    @GeneratedValue
    private Long identificacion;
    protected String nombre;
    protected String genero;
    protected Integer edad;
    protected String direccion;
    protected String telefono;
}
