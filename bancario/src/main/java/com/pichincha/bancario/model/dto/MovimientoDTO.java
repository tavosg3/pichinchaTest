package com.pichincha.bancario.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MovimientoDTO {
    private Long idMovimiento;
    private LocalDateTime fecha;
    private String tipo;
    private Double valor;
    private Double saldo;
}
