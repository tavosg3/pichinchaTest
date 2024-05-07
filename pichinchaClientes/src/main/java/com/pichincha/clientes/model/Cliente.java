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
public class Cliente extends Persona{

    @Id
    @GeneratedValue
    private Long clienteid;
    private String contrasena;
    private String estado;
}
