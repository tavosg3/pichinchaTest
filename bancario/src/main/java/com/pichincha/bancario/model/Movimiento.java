package com.pichincha.bancario.model;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
public class Movimiento {

    private Long idMovimiento;
    private LocalDateTime fecha;
    private String tipo;
    private Double valor;
    private Double saldo;
}
