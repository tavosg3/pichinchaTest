package com.pichincha.clientes.services.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class PersonaDTO {
    private Long identificacion;
    protected String nombre;
    protected String genero;
    protected Integer edad;
    protected String direccion;
    protected String telefono;
}
