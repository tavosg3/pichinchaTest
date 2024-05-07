package com.pichincha.clientes.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ClienteDTO extends PersonaDTO {

    private Long clienteid;
    private String contrasena;
    private String estado;
}
